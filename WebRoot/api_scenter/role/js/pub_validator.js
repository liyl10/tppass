// 验证仅允许汉字、字母
function nameValidate_a(o) {
 	var str=$(o).val();
	var obj = new RegExp(/^[A-Z|a-z|\u4e00-\u9fa5]*$/);
    str = str.replace(/\s+/g, '');
    $(o).val(str);
    if (!obj.test(str)) {
    	return false;
    }else{
    	return true;
    }
}