from selenium import webdriver
import time
from selenium.webdriver.support.select import Select # 专门处理下拉框元素

path = "E:\chromedriver\chromedriver.exe" # chromedriver路径
url = "https://kyfw.12306.cn/otn/leftTicket/init?" #12306网址

# 返回一个对象，browser就是我们的一个浏览器
browser = webdriver.Chrome(path)

time.sleep(5)
# 打开相应的URL网页
browser.get(url)

#元素定位

# 出发地ID fromStationText
start_city = browser.find_element_by_id("fromStationText")
#元素交互  模拟鼠标单击事件
start_city.click()
# 先清空在输入
start_city.clear()

start_city.send_keys("北京\n")

# 目的地ID toStationText
end_city = browser.find_element_by_id("toStationText")
end_city.click()
end_city.clear()
end_city.send_keys("上海\n")

# 下拉框ID cc_start_time
choice_time  =Select (browser.find_element_by_id("cc_start_time"))
# choice_time.select_by_index(); 按照下标查找元素
choice_time.select_by_visible_text("12:00--18:00")# 直接按文本内容选取

data = browser.find_element_by_css_selector("#``    data_range li:nth-child(4)")
data.click()

xpath = '//tbody[@id="queryLeftTable"]//td[4][@class]/../td[1]//a'
train_list = browser.find_elements_by_xpath(xpath)

#防止网络延迟
time.sleep(3)
for train in train_list:
    print(train.text)






