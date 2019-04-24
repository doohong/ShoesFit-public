var brandNameList;
var brandList;
var nameList;
var answer;
var shoes;
var ajaxFlag = true;
$(document).ready(function () {
    getList();
    startEvent();
});

function startEvent() {
    $(document).on("mouseover", ".brandLi", function () {
        var $hover = $("#hover");
        var index = $(this).siblings().index($hover);
        $(this).siblings().eq(index).removeAttr("id");
        $(this).attr("id", "hover");
    });
    $(document).on("mouseover", ".nameLi", function () {
        var $hover = $("#hover");
        var index = $(this).siblings().index($hover);
        $(this).siblings().eq(index).removeAttr("id");
        $(this).attr("id", "hover");
    });
    $(document).on("click", ".brandLi", function () {
        var value = $(this).text();
        var $input = $(this).parent("ul").parent("div").parent("div").find("input");
        $input.val(value);
        $input.trigger("click");
    });
    $(document).on("click", ".nameLi", function () {
        var value = $(this).text();
        var $input = $(this).parent("ul").parent("div").parent("div").find("input");
        $input.val(value);
        $input.trigger("click");
    });
    $("#startBtn").bind("click", function () {
        var scrollPosition = $("#footer").offset().top;
        $("html, body").animate({
            scrollTop: scrollPosition
        }, 500);
    });
    $("#confirmBtn").bind("click", function () {
        window.location.reload();
    });
    $("input[type=tel]").keypress(function (event) {
        if (event.which && (event.which <= 47 || event.which >= 58) && event.which != 8) {
            event.preventDefault();
        }
    });
    $("input[type=tel]").bind("focus", function () {
        $(".notHide").hide();
    });

    //브랜드 자동완성을 위한 이벤트
    $(".brand").on("keyup click focus", function (e) {
        var $brandLi = $(this).parent("div").find(".brandLi"); // List 전체

        if (e.keyCode == 13) { // 엔터키
            var value = keyupEnter($brandLi);
            if (value != undefined) {
                $(this).val(value);
            }
            $(this).trigger("click");
        } else if (e.keyCode == 40) {// 방향키 아래
            keyupDown($brandLi)
        } else if (e.keyCode == 38) {// 방향키 위

            keyupUp($brandLi)
        } else {// 다른 키 입력했을때
            autocomplete($(this).siblings("div"), brandList, $(this).val());
        }

    });

    //이름 자동완성을 위한 이벤트
    $(".name").on("keyup click focus", function (e) {
        var $nameLi = $(this).parent("div").find(".nameLi"); // List 전체

        if (e.keyCode == 13) { // 엔터키
            var value = keyupEnter($nameLi);
            if (value != undefined) {
                $(this).val(value);
            }
            $(this).trigger("click");
        } else if (e.keyCode == 40) {// 방향키 아래
            keyupDown($nameLi)
        } else if (e.keyCode == 38) {// 방향키 위
            keyupUp($nameLi);
        } else {// 다른 키 입력했을때

            autocomplete($(this).siblings("div"), brandNameList[$(this).parent("div").parent("div").find(".brand").val()], $(this).val());
        }

    });

    // 다른곳을 클릭했을때 자동완성 리스트 숨겨주는 이벤트
    $(document).on("click", function (e) {
        if (!$(e.target).hasClass("notHide") && !$(e.target).hasClass("brand") && !$(e.target).hasClass("name")) {
            $(".notHide").hide();
        }
    });
    // 신발 검색버튼 눌렀을때
    $("#oneShoesBtn").bind("click", function () {
        if (ajaxFlag) {
            checkValue(1);
        } else {
            alert("기다려주세요!");
        }
    })
    $("#twoShoesBtn").bind("click", function () {
        if (ajaxFlag) {
            checkValue(2);
        } else {
            alert("기다려주세요!");
        }
    })
    $("input").bind("keyup", function () {
        $(this).siblings(".warning").hide();
    })

}

//자동완성리스트 가져오는 함수
function getList() {
    $.ajax({
        url: "/events/list",
        type: 'post',
        success: function (data) {
            brandNameList = data.brandNameList;
            brandList = data.brandList;
            nameList = data.nameList;
        },
        error: function (error) {
            console.log(error);

        }
    });
}

function checkValue(flag) {
    var shoes = new Object();
    var inputflag = true;
    //신발1
    $("#shoes1Div input").each(function () {
        if ($(this).val().replace(/ /gi, "") == "") {
            $(this).siblings(".warning").show();
            inputflag = false;
        }
        shoes[$(this).attr("id")] = $(this).val();
    })
    //타겟
    $("#targetDiv input").each(function () {
        if ($(this).val().replace(/ /gi, "") == "") {
            $(this).siblings(".warning").show();
            inputflag = false;
            return;
        }
        shoes[$(this).attr("id")] = $(this).val();
    })
    if (flag == 2) {
        //신발2
        $("#shoes2Div input").each(function () {
            if ($(this).val().replace(/ /gi, "") == "") {
                $(this).siblings(".warning").show();
                inputflag = false;
                return;
            }
            shoes[$(this).attr("id")] = $(this).val();
        })
        if (inputflag) {
            JSON.stringify(shoes);
            searchTargetByTwoShoes(shoes);
        }
    }
    if (flag == 1) {
        if (inputflag) {
            searchTargetByOneShoes(shoes);
        }
    }
}

/**
 *
 * 수정 필요
 */
function searchTargetByOneShoes(shoes) {

    shoes = JSON.stringify(shoes);
    ajaxFlag = false;
    $.ajax({
        url: "/shoes/findOne",
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        data: shoes,
        success: function (data) {
            answer = data;
            makeAnswer(data);
        },
        error: function (error) {
            console.log(error);
        },
        complete: function () {
            ajaxFlag = true;
        }
    });


}

/**
 *
 * 수정 필요
 */

function searchTargetByTwoShoes(shoes) {

    shoes = JSON.stringify(shoes);
    ajaxFlag = false;
    $.ajax({
        url: "/shoes/findTwo",
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        data: shoes,
        success: function (data) {
            answer = data;
            makeAnswer(data);
        },
        error: function (error) {
            console.log(error);
        },
        complete: function () {
            ajaxFlag = true;
        }
    });


}

/**
 *
 * 수정 필요
 */
function makeAnswer(targetData) {
    $("#footerText").val("검색결과");
    $("#shoes1Div").hide();
    $("#shoes2Div").hide();
    $("#targetDiv").hide();
    $("#btnDiv").hide();
    $("#answerDiv").show();
    $("#targetBrandName").text(targetData.targetShoes.brand + targetData.targetShoes.name)
    if (targetData.targetSize.shoes1Count == 0 && (targetData.targetSize.shoes2Count == null || targetData.targetSize.shoes2Count == 0)) {
        $("#recommendMsg").text("검색결과가 존재하지 않습니다. 다른 신발로 검색 부탁드립니다.");
        return;
    }
    if (targetData.targetSize.shoes1Count != 0) {
        var percent = 100 / targetData.targetSize.shoes1Count;
        var text = targetData.shoes[0].brand + targetData.shoes[0].name + "의 검색 결과";
        for (var i = 0; i < targetData.targetSize.shoes1.length; i++) {
            text += targetData.targetSize.shoes1[i][0] + "사이즈" + percent * targetData.targetSize.shoes1[i][1] + "%(" + targetData.targetSize.shoes1[i][1] + ")";
        }
        text += "추천 드립니다."
        $("#shoes1RecommendSize").text(text);
    }

    if (targetData.targetSize.shoes2Count != 0 && targetData.targetSize.shoes2Count != null) {
        var percent = 100 / targetData.targetSize.shoes2Count;
        var text = targetData.shoes[1].brand + targetData.shoes[1].name + "의 검색 결과";
        for (var i = 0; i < targetData.targetSize.shoes2.length; i++) {
            text += targetData.targetSize.shoes2[i][0] + "사이즈" + percent * targetData.targetSize.shoes2[i][1] + "%(" + targetData.targetSize.shoes2[i][1] + ")";
        }
        text += "추천 드립니다."
        $("#shoes2RecommendSize").text(text);
    }

}



//신발 이름 자동완성 리스트 띄워주는 함수
function autocomplete($div, list, value) {
    if (list == null) list = [];
    var keyword = value; // 입력한값
    var $ul = $div.find("ul");
    $(".notHide").not($ul.children(".notHide")).hide();
    var $li = $div.find("li:first");
    $div.find("li").not($li).remove();
    keyword = keyword.split(" ").join("").toUpperCase();

    if (keyword == "") {
        var count = 0;
        list.forEach(function (item, index) {
            var $liClone = $li.clone();
            $liClone.show();
            $liClone.children(".regular:first").text(item);
            $ul.append($liClone);
            count++;
        });
        if (count != 0) {
            $ul.show();
        } else {
            $ul.hide();
        }
    } else {
        var count = 0;
        list.forEach(function (item, index) {
            var blankItem = item; // 띄어쓰기 있는 아이템
            item = item.split(" ").join("").toUpperCase();// 없는 아이템
            var startIndex = item.indexOf(keyword); // 처음인덱스
            var lastIndex = startIndex + keyword.length; // 마지막인덱스
            if (startIndex > -1 && keyword != "") {
                var blankArray = [];
                for (var x = 0; x < blankItem.length; x++) { // 문자열중 띄어쓰기 인덱스
                    // 저장
                    if (blankItem[x] == " ") {
                        blankArray.push(x);
                    }
                }
                blankArray.forEach(function (x) { // 띄어쓰기만큼 인덱스 증가
                    if (x <= startIndex) {
                        startIndex++;
                        lastIndex++;
                    }
                    if (x > startIndex && x <= lastIndex) {
                        lastIndex++;
                    }
                });
                var $liClone = $li.clone();
                $liClone.show();
                $liClone.children(".regular:first").text(blankItem.substring(0, startIndex));
                $liClone.children(".orange").text(blankItem.substring(startIndex, lastIndex));
                $liClone.children(".regular:last").text(blankItem.substring(lastIndex));
                $ul.append($liClone);
                count++;
            }
        });
        if (count != 0) {
            $ul.show();
        } else {
            $ul.hide();
        }
    }

}

function keyupUp($li) {
    var max = $li.length;
    var $hover = $("#hover") // 아이디값이 moveHover 엘리먼트
    index = $li.index($hover); // List중 아이디값을 가지고 있는

    if (max > 1) {
        if (index > 1) {
            $li.eq(index).removeAttr("id");
            $li.eq(index - 1).attr("id", "hover");
        } else if (index == 1) {
            $li.eq(index).removeAttr("id");
        } else return;
    }

}

function keyupDown($li) {
    var max = $li.length;
    var $hover = $("#hover") // 아이디값이 moveHover 엘리먼트
    index = $li.index($hover); // List중 아이디값을 가지고 있는

    if (max > 1) {
        if (index == -1) {
            $li.eq(1).attr("id", "hover");
        } else if (index < max - 1) {
            $li.eq(index).removeAttr("id");
            $li.eq(index + 1).attr("id", "hover");
        } else return;
    }
}

function keyupEnter($li) {
    var $hover = $("#hover") // 아이디값이 moveHover 엘리먼트
    index = $li.index($hover); // List중 아이디값을 가지고 있는
    if (index != -1) {
        return $li.eq(index).text();
    }
}