package org.jackysoft.util;

import java.util.HashMap;
import java.util.Map;

public class StyleManager {
	private static Map<String, String> styleManager = new HashMap<String, String>();
	static {
		styleManager
				.put("table",
						"background:#E6EAE9;border:gray dotted 1px;border-collapse:collapse");
		styleManager.put("td",
				"font: bold 14px \"Trebuchet MS\", Verdana, Arial, Helvetica, sans-serif;"
						+ "color: #4f6b72;"
						+ "border-right: 1px solid #E2F5BC;"
						+ "border-bottom: 1px solid #E2F5BC;"
						+ "border-top: 1px solid #E2F5BC;"
						+ "letter-spacing: 2px;" + "text-transform: uppercase;"
						+ "text-align: left;" + "padding: 6px 6px 6px 12px;"
						+ "background:#F5FAFe;");
		styleManager.put("th",
				"font: bold 14px \"Trebuchet MS\", Verdana, Arial, Helvetica, sans-serif;"
						+ "color: #000000;"
						+ "border-right: 1px solid #E2F5BC;"
						+ "border-bottom: 1px solid #E2F5BC;"
						+ "border-top: 1px solid #E2F5BC;"
						+ "letter-spacing: 2px;" + "text-transform: uppercase;"
						+ "text-align: left;" + "padding: 6px 6px 6px 12px;"
						+ "background:#CAE8Ee;");
		
		styleManager
				.put(
						"button",
						"BORDER-RIGHT: #7b9ebd 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #7b9ebd 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#cecfde); BORDER-LEFT: #7b9ebd 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #7b9ebd 1px solid");

		styleManager.put("button2k3", "font-family: \"tahoma\", \"宋体\";"
				+ "font-size:9pt; " + "color: #003399;"
				+ " border: 1px #003399 solid;" + " color:#006699;"
				+ "  border-bottom: #93bee2 1px solid;"
				+ "  border-left: #93bee2 1px solid;"
				+ " border-right: #93bee2 1px solid;"
				+ "  border-top: #93bee2 1px solid;"
				+ "   background-color: #e8f4ff;" + "  cursor: hand;"
				+ " font-style: normal ;   " + " width:60px;"
				+ "  height:24px;");
		styleManager.put("caption", "font-family: \"tahoma\", \"宋体\";"
				+ "font-size: 14px; " + "font-weight: bold;"
				+ "text-align:right;" + "color: #003333;"
				+ "border: 0px #93bee2 solid;"
				+ "border-bottom: #93bee2 1px solid;"
				+ "border-left: #93bee2 1px solid;"
				+ "border-right: #93bee2 1px solid;"
				+ "border-top: #93bee2 1px solid;"
				+ "background-color: #ffffff;" + "font-style: normal ;");
	}

	public static String getStyle(String tag) {
		return styleManager.get(tag);
	}
}
