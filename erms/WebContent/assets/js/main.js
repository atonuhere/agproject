$(document).on('click', "a.delete", function () {
	var sel = confirm('do you want to delete the widget?');
	if (sel) {
		// del code here
	}
});

// Load Sorted header table............
$(document).on('click', "#dispTable_List th.sortedtable", function () {
	var column = jQuery(this).attr("data-index");
	var order = jQuery(this).attr("data-order");
	ajaxPageSortLoad('dispTable_List', column, order);
		
}); 

//Load Fieldset collapsible............
$(function() {
$('fieldset.view_toggle').each(function() {
	var handler = $(this).find('legend');
	var toggledObject = $(this).find('.view_toggle_contents');
	toggledObject.hide();
	handler.click(function() {
		$(this).toggleClass('is_active_handler');
		toggledObject.slideToggle(600);

	});
});
});



function fixTrSerialNo() {
	var tableId = 'gridtable';
	var td = "table#" + tableId + ">tbody>tr";
	var i = 1;
	$(td).each(function() {
		try {
			if ($(this).attr("class") == 'jqgfirstrow') {

			} else {
				$(this).find("td:first").html(i);
			}

		} catch (Exception) {
			alert("error");
		}
		i++;
	});

}

function doAjaxDelete(url, eleId) {

	var con = confirm("Are you sure want to delete");
	if (con) {
		// if you need additional params to be passed - add to the data variable
		$.ajax({
			url : url,
			// data: data,
			async : false,
			type : "json",
			success : function(resp) {
				if (resp == 1) {
					// window.location.reload();
					$("#gridtable tr#" + eleId).remove();
					$("#gridtable").trigger("reloadGrid");
					// fixTrSerialNo();
				} else {
					alert(resp);
				}

			}

		});
	}

}

/* Javascript page redirect */
function gotoUrl(val) {
	window.location = val;

}
// ////convert dd/mm/yyyy to mm/dd/yyyy...............

function js_convert_date(date) {
	var split_date = date.split("/");
	var mod_date = new Date(split_date[1] + "/" + split_date[0] + "/"
			+ split_date[2]);
	var day = mod_date.getDate();
	var month = parseInt(mod_date.getMonth() + 1);
	var year = mod_date.getFullYear();
	var crdt = month + "/" + day + "/" + year;
	return crdt;
}

// ////convert yyyy-mm-ddT00:00:00 to dd/mm/yyyy ...............

function formatDate(value) {
	var dt = new String(value);
	var sr = new Date(String(dt));
	var date = new Date(sr), 
	mnth = ("0" + (date.getMonth() + 1)).slice(-2), 
	day = ("0" + date.getDate()).slice(-2);
	
	return [ day, mnth, date.getFullYear() ].join("/");
}

function currentDate() {
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1; // January is 0!

	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd;
	}
	if (mm < 10) {
		mm = '0' + mm;
	}
	var today = dd + '/' + mm + '/' + yyyy;
	return today;
}

// Loading Ajax Page thorugh pagination
function ajaxPageLoad(page, eleId) {
	var url = $('#ajaxPath').val();
	//var page = $('#pageNum').val();
	var sort = $('#sort').val();
	var order = $('#order').val();
	var searchString = $('#searchString').val();
	
	// if you need additional params to be passed - add to the data variable
	ajaxLoadingIcon();

	$.ajax({
		url : url,
		data : {
			"elementId" : eleId,
			"page" : page,
			"ajaxPath" : url,
			"sort" : sort,
			"order" : order,
			"searchString": searchString
		},
		async : false,
		success : function(resp) {
			
			$("#" + eleId).html(resp);
			ajaxLoadingIconComplete();
			$('#pageNum').val(page);

		},
		error : function(resp) {
			alert(resp);
		}

	});

}
function ajaxPageSearchLoad(eleId, searchString) {
	var url = $('#ajaxPath').val();
	//var page = $('#pageNum').val();
	var page=1; //By default it starts with first page
	var sort = $('#sort').val();
	var order = $('#order').val();
	//var searchString = $('#searchString').val();

	// if you need additional params to be passed - add to the data variable
	ajaxLoadingIcon();

	$.ajax({
		url : url,
		data : {
			"elementId" : eleId,
			"page" : page,
			"ajaxPath" : url,
			"sort" : sort,
			"order" : order,
			"searchString" : searchString
		},
		async : false,
		success : function(resp) {
			$("#" + eleId).html(resp);
			ajaxLoadingIconComplete();
			$('#searchString').val(searchString);

		},
		error : function(resp) {
			alert(resp);
		}

	});

}
//Loading Ajax Page thorugh pagination
function ajaxPageSortLoad(eleId, sort, order) {
	var url = $('#ajaxPath').val();
	var page = $('#pageNum').val();
	//var sort = $('#sort').val();
	//var order = $('#order').val();
	var searchString = $('#searchString').val();
	// if you need additional params to be passed - add to the data variable
	ajaxLoadingIcon();

	$.ajax({
		url : url,
		data : {
			"elementId" : eleId,
			"page" : page,
			"ajaxPath" : url,
			"sort" : sort,
			"order" : order,
			"searchString" : searchString
		},
		async : true,
		cache : false,
		success : function(resp) {
			$("#" + eleId).html(resp);
			ajaxLoadingIconComplete();
			$('#sort').val(sort);
			$('#order').val(order);
			changeSort(order,sort);
		},
		error : function(resp) {
			alert(resp);
		}

	});

}
function changeSort(order,index){
	var classUp = "icon-chevron-up glyphicon glyphicon-chevron-up";
	var classDown = "icon-chevron-down glyphicon glyphicon-chevron-down";
	var element=$('table th[data-index="'+index+'"]');
		
	$('th.sortedtable').each(function(key, value) {
		$(this).removeClass('message-ie');
		
	});
	
	if (order == "asc") {
		$(element).find("i").removeClass(classDown).addClass(classUp);
		$(element).attr('data-order','desc');
		$(element).addClass('message-ie');
		
	} else {
		$(element).find("i").addClass(classDown).removeClass(classUp);
		$(element).attr('data-order','asc');
		$(element).addClass('message-ie');
	}
}
function searchPage() {
	
	var searchStr = "";
	$formDivInput = $('#searchForm input');
	$formDivSelect = $('#searchForm select');
	
	var elemname="", strvalue="";
	
	$.each($formDivInput, function(key, value) {
		elemname = $(this).attr("name");
		strvalue = $(this).val();
		if (strvalue.length>0){
			searchStr += elemname + "=" + strvalue + "#";
		}	

	});
	
	$.each($formDivSelect, function(key, value) {
		elemname = $(this).attr("name");
		strvalue = $(this).val();
		if (strvalue != undefined && strvalue.length>0){
			searchStr += elemname + "=" + strvalue + "#";
		}	

	});
	
	ajaxPageSearchLoad('dispTable_List',  searchStr);
}
function ajaxLoadingIcon() {
	$('#loadingAjaxicon').show();
	var $icon = $(this).find(".icon-refresh"), animateClass = "icon-refresh-animate";
	$icon.addClass(animateClass);
}

function ajaxLoadingIconComplete() {
	var $icon = $(this).find(".icon-refresh"), animateClass = "icon-refresh-animate";
	$icon.removeClass(animateClass);
	$('#loadingAjaxicon').hide();
}

function convertDouble(num) {
	var number = parseFloat(num);
	return number.toFixed(2);
}

function clearSearch(eleId){
	$('#pageNum').val(1);
	$('#sort').val('id');
	$('#order').val('asc');
	$('#searchString').val('');
	$('#searchForm input').val("");
	$('#searchForm select').val("");
	ajaxPageLoad(1, eleId);
}

/////////###############################################

////////////////get current date in unix timestamp................
var monthname=new Array("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
function getfullday(n) { // convert cardinal number to ordinal number
	var n = Math.abs(n);
	var ord;
	ord = 'th';
	switch (n % 10) {
	case 1: ord = 'st'; break;
	case 2: ord = 'nd'; break;
	case 3: ord = 'rd'; break;
	default: ord = 'th'; break;
	} // end switch
	// check for teen values
	if (n > 10 && n < 14) ord = 'th';
	return n + ord;
}
var today = new Date();
var dd = today.getDate();
var mm = parseInt(today.getMonth()+1);//January is 0!

var yyyy = today.getFullYear();
if(dd<10){dd='0'+dd}
if(mm<10){mm='0'+mm}
var cur_dat = dd+'/'+mm+'/'+yyyy; // get current date in DD/MM/YYYY format
//var cur_date = convert_date_to_timestamp(cur_dat); // get current date in TIMESTAMP...
///////////////////////////////////end current date in unix timestamp................


// New date formate like (1st jan 2013)................
var ddd = getfullday(dd);
var mmm = monthname[today.getMonth()];//January is 0!
var cur_mod_date = ddd+'-'+mmm+'-'+yyyy;
function getModDateformat(dt){
	var split_date = dt.split("/");
	var day = getfullday(split_date[0]);
	var month = parseInt(split_date[1]-1);
	var mnth = monthname[month];
	var year = split_date[2];
	var cdt = day + " " + mnth + ", " + year ;
	return cdt;
}

/////###############################################
function ajaxBigLoadingIcon() {
	$('#loadingBigIcon').show();
}

function ajaxBigLoadingIconComplete() {
	$('#loadingBigIcon').hide();
}