<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>折线图</title>
    <style>
        *{margin:0;padding:0;}
    </style>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 统计管理 <span class="c-gray en">&gt;</span> 全国各大省份人气小吃 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<!--<div class="pd-20">-->

    <center><h1><strong>全国各大省份人气小吃-数据可视化(数据来源美食节官网)</strong></h1></center>

   

    <div id="main" style="height:500px"></div>
    <script src="js/echarts.js"></script>
    <script>
        // 路径配置
        require.config({
            paths: {
                echarts: './js'
            }
        });




        // 使用
        require(['echarts', 'echarts/chart/map'], function (ch) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ch.init(document.getElementById('main'));
            option = {
                tooltip: {
                    trigger: 'item',
                    formatter: '{b}'
                },
                series: [{
                    name: '中国',
                    type: 'map',
                    mapType: 'china',
                    selectedMode: 'single',//multiple多选
                    itemStyle: {
                        normal: {
                            label: {
                                show: true,
                                textStyle: {
                                    color: "#231816"
                                }
                            },
                            areaStyle: { color: '#B1D0EC' },
                            color: '#B1D0EC',
                            borderColor: '#dadfde'//区块的边框颜色
                        },
                        emphasis: {//鼠标hover样式
                            label: {
                                show: true,
                                textStyle: {
                                    color: '#fa4f04'
                                }
                            }
                        }
                    },
                    data: [
                        { name: '四川', selected: false }//true
                    ]
                }]
            };
            var ecConfig = require('echarts/config');
            myChart.on(ecConfig.EVENT.MAP_SELECTED, function (param) {
                var selected = param.selected;
                var urlArr = ['www/Henan_Snacks.html', 'www/Chongqin_Snacks.html', 'www/Beijing_Snacks.html', 'www/Anhui_Snacks.html', 'www/Sicuan_Snacks.html', 'www/Fujian_Snacks.html', 'www/Gansu_Snacks.html', 'www/Guangdong_Snacks.html', 'www/Guangxi_Snacks.html', 'www/Guizhou_Snacks.html', 'www/Hainan_Snacks.html', 'www/Hebei_Snacks.html', 'www/Heilongjiang_Snacks.html', 'www/Hubei_Snacks.html', 'www/Hunan_Snacks.html', 'www/Jilin_Snacks.html', 'www/Jiangsu_Snacks.html', 'www/Jiangxi_Snacks.html', 'www/Liaoning_Snacks.html', 'www/Menggu_Snacks.html', 'www/Ningxia_Snacks.html', 'www/Qinghai_Snacks.html', 'www/Shandong_Snacks.html', 'www/Shanxi_Snacks.html', 'www/shanxi陕西_Snacks.html', 'www/Shanghai_Snacks.html', 'www/Taiwan_Snacks.html', 'www/Tianjing_Snacks.html', 'www/Xizang_Snacks.html', 'www/Xiangguang_Snacks.html', 'www/Xinjiang_Snacks.html', 'www/Yunnan_Snacks.html', 'www/Zhejiang_Snacks.html'];//各城市小吃跳转页面链接url
                for (var p in selected) {
                    if (selected[p]) {
                        switch (p) {
                            case '河南':
                                location.href = urlArr[0];
                                break;
                            case '重庆':
                                location.href = urlArr[1];
                                break;
                            case '北京':
                                location.href = urlArr[2];
                                break;
                            case '安徽':
                                location.href = urlArr[3];
                                break;
                            case '四川':
                                location.href = urlArr[4];
                                break;
                            case '福建':
                                location.href = urlArr[5];
                                break;
                            case '甘肃':
                                location.href = urlArr[6];
                                break;
                            case '广东':
                                location.href = urlArr[7];
                                break;
                            case '广西':
                                location.href = urlArr[8];
                                break;
                            case '贵州':
                                location.href = urlArr[9];
                                break;
                            case '海南':
                                location.href = urlArr[10];
                                break;
                            case '河北':
                                location.href = urlArr[11];
                                break;
                            case '黑龙江':
                                location.href = urlArr[12];
                                break;
                            case '湖北':
                                location.href = urlArr[13];
                                break;
                            case '湖南':
                                location.href = urlArr[14];
                                break;
                            case '吉林':
                                location.href = urlArr[15];
                                break;
                            case '江苏':
                                location.href = urlArr[16];
                                break;
                            case '江西':
                                location.href = urlArr[17];
                                break;
                            case '辽宁':
                                location.href = urlArr[18];
                                break;
                            case '内蒙古':
                                location.href = urlArr[19];
                                break;
                            case '宁夏':
                                location.href = urlArr[20];
                                break;
                            case '青海':
                                location.href = urlArr[21];
                                break;
                            case '山东':
                                location.href = urlArr[22];
                                break;
                            case '山西':
                                location.href = urlArr[23];
                                break;
                            case '陕西':
                                location.href = urlArr[24];
                                break;
                            case '上海':
                                location.href = urlArr[25];
                                break;
                            case '台湾':
                                location.href = urlArr[26];
                                break;
                            case '天津':
                                location.href = urlArr[27];
                                break;
                            case '西藏':
                                location.href = urlArr[28];
                                break;
                            case '香港':
                                location.href = urlArr[29];
                                break;
                            case '新疆':
                                location.href = urlArr[30];
                                break;
                            case '云南':
                                location.href = urlArr[31];
                                break;
                            case '浙江':
                                location.href = urlArr[32];
                                break;
                            default:
                                break;
                        }

                    }
                }
            });
            // 为echarts对象加载数据
            myChart.setOption(option);
        });
    </script>
<!--	<div id="container" style="min-width:700px;height:400px"></div>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<script type="text/javascript" src="lib/Highcharts/4.1.7/js/highcharts.js"></script>
<script type="text/javascript" src="lib/Highcharts/4.1.7/js/modules/exporting.js"></script>-->
<!--<script type="text/javascript">
$(function () {
    $('#container').highcharts({
        title: {
            text: 'Monthly Average Temperature',
            x: -20 //center
        },
        subtitle: {
            text: 'Source: WorldClimate.com',
            x: -20
        },
        xAxis: {
            categories: ['一月', '二月', '三月', '四月', '五月', '六月','七月', '八月', '九月', '十月', '十一月', '十二月']
        },
        yAxis: {
            title: {
                text: 'Temperature (°C)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '°C'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'Tokyo',
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
        }, {
            name: 'New York',
            data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]
        }, {
            name: 'Berlin',
            data: [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]
        }, {
            name: 'London',
            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
        }]
    });
});
</script>-->
</body>
</html>