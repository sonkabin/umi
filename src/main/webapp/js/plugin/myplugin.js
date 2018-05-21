//基础url
baseUrl = 'http://localhost:8080/umi'

//时间戳转换成日期
function getDate(timestamp) {
  // timestamp是整数，否则要parseInt转换
  var time = new Date(timestamp);
  var y = time.getFullYear();
  var m = time.getMonth() + 1;
  var d = time.getDate();
  return y + '-' + m + '-' + d;
}
// 时间戳转换,精确到秒
function getDateTime(timestamp) {
  var time = new Date(timestamp);
  var y = time.getFullYear();
  var m = time.getMonth() + 1;
  var d = time.getDate();
  var h = time.getHours();
  var mm = time.getMinutes();
  var s = time.getSeconds();
  if (h < 10) {
    h = '0' + h;
  }
  if (mm < 10) {
    mm = '0' + mm;
  }
  if (s < 10) {
    s = '0' + s;
  }
  return y + '-' + m + '-' + d + ' ' + h + ':' + mm + ':' + s;
}

//解析显示分页信息
function build_page_info(node,info) {
  $(node).empty();
  $(node).append(
    '&nbsp;&nbsp;&nbsp;当前第' + info.pageNum + '页，共' + info.pages +
    '页，共' + info.total + '条记录');
  var record = {
    "totalRecord": info.total,
    "currentPage": info.pageNum
  };
  return record;
}

//显示分页条
function build_nav(node , info) {
  $(node).empty();
  var ul = $('<ul></ul>').addClass('pagination');
  var firstPageLi = $('<li></li>').append($('<a></a>').append('首页'))
    .attr('href', '#');
  var prePageLi = $('<li></li>').append(
    $('<a></a>').append('&laquo;'));
  if (info.hasPreviousPage == false) {
    firstPageLi.addClass('disabled');
    prePageLi.addClass('disabled');
  } else {
    firstPageLi.click(function() {
      to_page(1);
    })
    prePageLi.click(function() {
      to_page(info.prePage);
    })
  }
  ul.append(firstPageLi).append(prePageLi);

  $.each(info.navigatepageNums, function(index, item) {
    var li = $('<li></li>').append($('<a></a>').append(item));
    if (info.pageNum == item) {
      li.addClass('active');
    }
    li.click(function() {
      to_page(item);
    })
    ul.append(li);
  })

  var lastPageLi = $('<li></li>').append($('<a></a>').append('末页'))
    .attr('href', '#');
  var nextPageLi = $('<li></li>').append(
    $('<a></a>').append('&raquo;'));
  if (info.hasNextPage == false) {
    lastPageLi.addClass('disabled');
    nextPageLi.addClass('disabled');
  } else {
    lastPageLi.click(function() {
      to_page(info.pages);
    })
    nextPageLi.click(function() {
      to_page(info.nextPage);
    })
  }
  ul.append(nextPageLi).append(lastPageLi);
  $(node).append(ul);
}
