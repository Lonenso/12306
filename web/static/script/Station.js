var cities = new Array();
cities['北京']=new Array('北京');
cities['上海']=new Array('上海');
cities['天津']=new Array('天津');
cities['重庆']=new Array('重庆');
// cities['河北省']=new Array('石家庄', '张家口', '承德', '秦皇岛', '唐山', '廊坊', '保定', '沧州', '衡水', '邢台', '邯郸');
cities['山西省']=new Array('太原');
cities['辽宁省']=new Array('沈阳');
cities['吉林省']=new Array('长春');
cities['黑龙江省']=new Array('哈尔滨');
cities['江苏省']=new Array('南京');
cities['浙江省']=new Array('杭州');
// cities['安徽省']=new Array('合肥', '宿州', '淮北', '阜阳', '蚌埠', '淮南', '滁州', '马鞍山', '芜湖', '铜陵', '安庆', '黄山', '六安', '巢湖', '池州', '宣城');
// cities['福建省']=new Array('福州', '南平', '三明', '莆田', '泉州', '厦门', '漳州', '龙岩', '宁德');
// cities['江西省']=new Array('南昌', '九江', '景德镇', '鹰潭', '新余', '萍乡', '赣州', '上饶', '抚州', '宜春', '吉安');
// cities['山东省']=new Array('济南', '聊城', '德州', '东营', '淄博', '潍坊', '烟台', '威海', '青岛', '日照', '临沂', '枣庄', '济宁', '泰安', '莱芜', '滨州', '菏泽');
cities['河南省']=new Array('郑州');
cities['湖北省']=new Array('武汉');
cities['湖南省']=new Array('长沙');
// cities['广东省']=new Array('广州', '清远', '韶关', '河源', '梅州', '潮州', '汕头', '揭阳', '汕尾', '惠州', '东莞', '深圳', '珠海', '江门', '佛山', '肇庆', '云浮', '阳江', '茂名', '湛江');
// cities['海南省']=new Array('海口', '三亚');
cities['四川省']=new Array('成都');
// cities['贵州省']=new Array('贵阳', '六盘水', '遵义', '毕节', '铜仁', '安顺', '黔东南', '黔南', '黔西南');
// cities['云南省']=new Array('昆明', '曲靖', '玉溪', '丽江', '昭通', '思茅', '临沧', '保山', '德宏', '怒江', '迪庆', '大理', '楚雄', '红河', '文山', '西双版纳');
cities['陕西省']=new Array('西安');
// cities['甘肃省']=new Array('兰州', '嘉峪关', '金昌', '白银', '天水', '酒泉', '张掖', '武威', '庆阳', '平凉', '定西', '陇南', '临夏', '甘南');
cities['青海省']=new Array('西宁');
// cities['内蒙古']=new Array('呼和浩特', '包头', '乌海', '赤峰', '呼伦贝尔盟', '兴安盟', '哲里木盟', '锡林郭勒盟', '乌兰察布盟', '鄂尔多斯', '巴彦淖尔盟', '阿拉善盟');
// cities['广西']=new Array('南宁', '桂林', '柳州', '梧州', '贵港', '玉林', '钦州', '北海', '防城港', '南宁', '百色', '河池', '柳州', '贺州');
// cities['西藏']=new Array('拉萨', '那曲', '昌都', '林芝', '山南', '日喀则', '阿里');
// cities['宁夏']=new Array('银川', '石嘴山', '吴忠', '固原');
cities['新疆']=new Array('乌鲁木齐');
// cities['香港']=new Array('香港');
// cities['澳门']=new Array('澳门');
// cities['台湾']=new Array('台北','台南','其他');

function loadCity_from() {
    var city = document.getElementById("city_from");
    var pro = document.getElementById("province_from");
    var index = pro.options[pro.selectedIndex].value;
    city.innerHTML = "";
    for (var i in cities[index]) {
        var op = new Option(cities[index][i], cities[index][i]);
        city.add(op);
    }
}
function loadCity_to() {
    var city = document.getElementById("city_to");
    var pro = document.getElementById("province_to");
    var index = pro.options[pro.selectedIndex].value;
    city.innerHTML = "";
    for (var i in cities[index]) {
        var op = new Option(cities[index][i], cities[index][i]);
        city.add(op);
    }
}

window.onload = function() {
    var pro1 = document.getElementById("province_from");
    var pro2 = document.getElementById("province_to");
    for (var p in cities) {
        var op = new Option(p, p);
        pro1.add(op);
    }
    for (var p in cities) {
        var op = new Option(p, p);
        pro2.add(op);
    }
    showdate();
    loadCity_from();
    loadCity_to();
    pro1.onchange = function() {
        loadCity_from();
    }
    pro2.onchange =function () {
        loadCity_to();
    }
}

function showdate() {
    var Today = new Date();
    var yearObj = document.getElementById("year");
    var monthObj = document.getElementById("month");
    var dateObj = document.getElementById("date");

    //清空年份下拉列表
    // noinspection JSAnnotator
    yearObj.options.length = 0;
    // noinspection JSAnnotator
    monthObj.options.length = 0;
    // noinspection JSAnnotator
    dateObj.options.length = 0;
    for (var i = 2017; i <= 2019; i++) {
        var year = new Option(i, i);
        yearObj.options.add(year);
    }
    for (var i = 1; i <= 12; i++) {
        var month = new Option(i, i);
        monthObj.options.add(month);
    }
    for (var i = 1; i <= 31; i++) {
        var date = new Option(i, i);
        dateObj.options.add(date);
    }
}

function isToday() {
    var Today = new Date();
    var yearObj = document.getElementById("year");
    var monthObj = document.getElementById("month");
    var month = monthObj.value;
    var year = yearObj.value;

    // noinspection JSAnnotator
    monthObj.options.length = 0;
    for (var i = 1; i <= 12; i++) {
        var month = new Option(i, i);
        monthObj.options.add(month);
    }

    // if (year == Today.getFullYear()) {
    //     for (var i = 1; i <= Today.getMonth() + 1; i++) {
    //         var month = new Option(i, i);
    //         monthObj.options.add(month);
    //     }
    // } else {
    //
    //     }
    // }
}

//当月份改变时，日期也会随着改变
function changeDate() {
    var Today = new Date();
    var yearObj = document.getElementById("year");
    var monthObj = document.getElementById("month");
    var dateObj = document.getElementById("date");
    var month = monthObj.value;
    var year = yearObj.value;
    // noinspection JSAnnotator
    dateObj.options.length = 0;

    if (month == Today.getMonth() + 1 && year == Today.getFullYear()) {
        for (var i = 1; i <= Today.getDate(); i++) {
            var date = new Option(i, i);
            dateObj.options.add(date);
        }
    } else {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            for (var i = 1; i <= 30; i++) {
                var day = new Option(i, i);
                dateObj.options.add(day);
            }
        }
        else if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                for (var i = 1; i <= 29; i++) {
                    var day = new Option(i, i);
                    dateObj.options.add(day);
                }
            } else {
                for (var i = 1; i <= 28; i++) {
                    var day = new Option(i, i);
                    dateObj.options.add(day);
                }
            }
        }
        //其他月份都是31天
        else {
            for (var i = 1; i <= 31; i++) {
                var day = new Option(i, i);
                dateObj.options.add(day);
            }
        }
    }
}

