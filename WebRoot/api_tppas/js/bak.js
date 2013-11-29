{
		cookieLang(function($obj){// 如果国际化下拉框无法正常初始化，则从cookie取语言标记
			var sLang = cookieUtils.get("WEBSITE_LANG");
			if (checkUtils.isEmpty(sLang)){// cookie没有语言信息 默认是简体中文
				sLang = upmsUtils.getSysLanguage();
				cookieUtils.set("WEBSITE_LANG",sLang);
			}
			switch (sLang){
				case "zh-cn":
					var sHtml = [];
					sHtml.push("<span>简体中文</span>");
					sHtml.push("<div>");
					sHtml.push("<a href='javascript: void(0);' onClick=\"changeLang('en-us')\">English</a>");
					sHtml.push("<a href='javascript: void(0);' onClick=\"changeLang('zh-tw')\">繁体中文</a>");
					sHtml.push("</div>");
					$obj.prepend(sHtml.join(""));
					break;
				case "en-us":
					var sHtml = [];
					sHtml.push("<span>English</span>");
					sHtml.push("<div>");
					sHtml.push("<a href='javascript: void(0);' onClick=\"changeLang('zh-cn')\">简体中文</a>");
					sHtml.push("<a href='javascript: void(0);' onClick=\"changeLang('zh-tw')\">繁体中文</a>");
					sHtml.push("</div>");
					$obj.prepend(sHtml.join(""));						
					break;
				case "zh-tw":
					var sHtml = [];
					sHtml.push("<span>繁体中文</span>");
					sHtml.push("<div>");
					sHtml.push("<a href='javascript: void(0);' onClick=\"changeLang('zh-cn')\">简体中文</a>");
					sHtml.push("<a href='javascript: void(0);' onClick=\"changeLang('en-us')\">English</a>");
					sHtml.push("</div>");
					$obj.prepend(sHtml.join(""));							
					break;
				default:
					break;
			}			
		})
}