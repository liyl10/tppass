//文字型焦点进入事件
function focusText(now) {
	if (now.value == "无" || now.value == "0" || now.value == "0.0") {
		now.value = "";
	}
	$("#error" + now.id).remove();
}

// 文字型焦点离开事件
function blurText(now, text, spaceFlag, type) {
	var flag = true;
	if ($.trim(now.value) == "") {
		if (spaceFlag == 1) {
			$("#error" + now.id).remove();
			var span = $("<div id='error" + now.id
					+ "'><span style='color:red;'>" + text
					+ "不能为空！</span></div>");
			$(now).parent().append(span);
			flag = false;
		} else {
			if (type == 1) {
				now.value = "无";
			} else if (type == 2) {
				now.value = "0";
			} else if (type == 3) {
				now.value = "0.0";
			}else if (type == 9) {
				now.value = "0.0";
			}
		}
	} else {
		if (spaceFlag == 0
				&& (now.value == "0" || now.value == "0.0" || now.value == "无")) {
			$("#error" + now.id).remove();
			return true;
		}

		// 数字验证（小数）
		if (type == 3) {
			/* var pattern = /^[1-9]\d*(\.\d)?|(0\.\d)?$/; */
			var pattern = /^(([1-9]\d{0,6})|0)(\.\d{1,4})?$/;
			var result = pattern.test(now.value);
			if (!result) {
				$("#error" + now.id).remove();
				var span = $("<div id='error" + now.id
						+ "'><span style='color:red;'>" + text
						+ "格式不正确，整数位长度不能超过7，小数位长度不能超过4！</span></div>");
				$(now).parent().append(span);
				flag = false;
			}
		}
		// 日期验证
		else if (type == 8) {
			var pattern = /^[1-2][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9]$/;
			var result = pattern.test(now.value);
			if (!result) {
				$("#error" + now.id).remove();
				var span = $("<div id='error" + now.id
						+ "'><span style='color:red;'>" + text
						+ "格式不正确！</span></div>");
				$(now).parent().append(span);
				flag = false;
			}
		}
		// 日期
		else if (type == 5) {
			$("#error" + now.id).remove();
			var span = $("<div id='error" + now.id
					+ "'><span style='color:red;'>" + text
					+ "不能多于3个！</span></div>");
			$(now).parent().append(span);
			flag = false;
		}

		else if (type == 2) {
			/* var pattern = /^[1-9]\d*(\.\d)?|(0\.\d)?$/; */

			var pattern = /^(([1-9]\d{0,6})|0)(\.\d{1,4})?$/;
			var result = pattern.test(now.value);
			if (!result) {
				$("#error" + now.id).remove();
				var span = $("<div id='error" + now.id
						+ "'><span style='color:red;'>" + text
						+ "格式不正确！</span></div>");
				$(now).parent().append(span);
				flag = false;
			}
		}

		else if (type == 9) {
			/* var pattern = /^[1-9]\d*(\.\d)?|(0\.\d)?$/; */
			var pattern = /^(([1-9]\d{0,5})|0)(\.\d{1,4})?$/;
			var result = pattern.test(now.value);
			if (!result) {
				$("#error" + now.id).remove();
				var span = $("<div id='error" + now.id
						+ "'><span style='color:red;'>" + text
						+ "格式不正确，整数位长度不能超过6，小数位长度不能超过4！</span></div>");
				$(now).parent().append(span);
				flag = false;
			}
		} else if (type == 7) {
			$("#error" + now.id).remove();
		}

	}
	return flag;
}
