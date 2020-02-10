# 导入相应的文件
import requests
import json
import re
import time
import jieba
import wordcloud

# 加入请求头
headers = {
    "Referer": "https://m.weibo.cn/",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36"
}

# 创建TXT文件
f = open('./weibo.txt', 'a+', encoding='utf-8')


# 获取cookies值
def get_cookie():
    # 原始网页的URL
    url = "https://m.weibo.cn"
    s = requests.Session()
    s.get(url, headers=headers, timeout=3)  # 请求首页获取cookies
    cookie = s.cookies  # 为此次获取的cookies
    return cookie


# 获取一次cookies，这里面包含一个时间戳，确保后面的信息是一条时间线上的
cookies = get_cookie()


# 定义获取信息的函数
def get_info(url):
    rs = requests.get(url=url, headers=headers, timeout=3, cookies=cookies)
    print(url, rs)
    json_data = json.loads(rs.text)

    results = json_data['data']['statuses']
    for result in results:
        text = re.sub('<.*?>', '', str(result['text']))
        print(text + '\n-----------------\n')
        f.write(text + '\n\n')


# 定义生成词云的函数
def wordcloud_image():
    file = open('./weibo.txt', encoding='utf-8')
    txt = file.read()

    w = wordcloud.WordCloud(width=1000, height=700, font_path="msyh.ttc")
    jieba.del_word('全文')
    w.generate(" ".join(jieba.lcut(txt)))
    w.to_file("wuhan.jpg")

    file.close()


if __name__ == '__main__':
    # 爬取i页，可自行修改
    urls = ["https://m.weibo.cn/api/feed/trendtop?containerid=102803_ctg1_600059_-_ctg1_600059&page={}".format(i) for i
            in range(1, 10)]
    for url in urls:
        get_info(url)
        # 测试少量爬取时间隔3秒，这里建议间隔20秒，不然容易出现403
        time.sleep(3)
    f.close()

    wordcloud_image()


