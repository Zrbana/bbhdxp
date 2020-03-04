/*
interface Success {
    void callback(String data);
}

class Option {
    String method;
    String url;
    String dataType;
    Success callback;
}

class $ {
    public static void ajax(Option option) {
        发起 ajax 情况
    }
}

$.ajax(new Option(
    method:
    url:
    dataType:
    成功之后的会调用我的什么方法进行数据处理
));
 */
$.ajax(
    {
        method: "get",  // 发起 ajax 请求时，使用什么 http 方法
        url: "rank.json",   // 请求哪个 url
        dataType: "json",   // 返回的数据当成什么格式解析
        success: function (data) {  // 成功后，执行什么方法
            var names = [];
            var counts = [];

            for (var i in data) {
                names.push(data[i][0]);
                counts.push(data[i][1]);
            }

            console.log(names);
            console.log(counts);
            var myChart = echarts.init(document.getElementById('main'));

            var option = {
                // 图标的标题
                title: {
                    text: 'ECharts 入门示例'
                },
                tooltip: {},
                legend: {
                    data:['销量']
                },
                // 横坐标
                xAxis: {
                    data: names
                },
                yAxis: {},
                series: [
                    {
                        name: '销量',
                        type: 'bar',    // bar 代表柱状图
                        itemStyle: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#83bff6'},
                                    {offset: 0.5, color: '#188df0'},
                                    {offset: 1, color: '#188df0'}
                                ]
                            )
                        },
                        emphasis: {
                            itemStyle: {
                                color: new echarts.graphic.LinearGradient(
                                    0, 0, 0, 1,
                                    [
                                        {offset: 0, color: '#2378f7'},
                                        {offset: 0.7, color: '#2378f7'},
                                        {offset: 1, color: '#83bff6'}
                                    ]
                                )
                            }
                        },
                        data: counts
                    }
                ]
            };

            myChart.setOption(option);
        }
    }
);
