package org.jackysoft.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import org.apache.commons.collections.FastArrayList;

/**
 * @author qujiakang 字符串操作的类
 */

public class StringUtils extends org.apache.commons.lang3.StringUtils {
	/**
	 * @author qujiakang
	 * @param s
	 *            要解析的字符串
	 * @param token
	 *            令牌
	 * @return List 解析出来的字符串列表 例如 :s=励,精,图,治水,滴石穿 结果 list={励,精,图,治水,滴石穿};
	 */
	@SuppressWarnings("unchecked")
	public static List<String> parseRexString(String s, String token) {
		if (null == s || null == token)
			throw new NullPointerException("s : " + s + "token :" + token
					+ " 空值错误");
		List<String> list = new FastArrayList();
		StringTokenizer st = new StringTokenizer(s);
		while (st.hasMoreTokens()) {
			list.add(st.nextToken(token).trim());
		}

		return list;
	}

	public String parseEncode(String s, Charset from, Charset to) {
		s = new String(s.getBytes(from), to);
		return s;
	}

	/**
	 * @author qujiakang
	 * @param Calendar
	 *            对象
	 * @return 返回传入的日历对象的字符串表示
	 */
	public static String formatDateString(Calendar d) {
		if (d == null)
			d = Calendar.getInstance();
		int year = d.get(Calendar.YEAR);
		int month = d.get(Calendar.MONTH) + 1;
		int date = d.get(Calendar.DAY_OF_WEEK) - 1;
		int day = d.get(Calendar.DATE);
		int hour = d.get(Calendar.HOUR);
		int minute = d.get(Calendar.MINUTE);
		int second = d.get(Calendar.SECOND);
		StringBuffer datetime = new StringBuffer();
		datetime.append(year);
		datetime.append("<font color=green>-</font>");
		datetime.append(month);
		datetime.append("<font color=green>-</font>");
		datetime.append(day);
		datetime.append("<font color=green>-[</font>");
		datetime.append(hour);
		datetime.append("<font color=green>:</font>");
		datetime.append(minute);
		datetime.append("<font color=green>:</font>");
		datetime.append(second);
		datetime.append("<font color=green>:</font>");
		datetime.append("<font color=green>星期 </font>");
		datetime.append(date);
		datetime.append("<font color=green>]</font>");
		return datetime.toString();
	}

	/**
	 * @return 把一个字符串的首字母大写
	 */
	public static String upperFirstChar(String target) {
		if (target == null || "".equals(target))
			return "";

		char[] chars = target.toCharArray();
		Character fc = Character.toUpperCase(chars[0]);
		chars[0] = fc;
		return new String(chars);
	}
	/**
	 * @return 把一个字符串的首字母小写
	 */
	public static String lowerFirstChar(String target) {
		if (target == null || "".equals(target))
			return "";
		
		char[] chars = target.toCharArray();
		Character fc = Character.toLowerCase(chars[0]);
		chars[0] = fc;
		return new String(chars);
	}

	/**
	 * @param String
	 * @return boolean 类型 指示对象字符串是否空或Null
	 */
	public static boolean nullableString(String s) {
		if ("".equalsIgnoreCase(s) || null == s)
			return true;
		else
			return false;
	}

	public static String[] splitFileName(String fileName) {
		if (fileName == null)
			return null;
		String[] sfile = new String[2];
		sfile[0] = fileName.substring(0, fileName.lastIndexOf('.'));
		sfile[1] = fileName.substring(fileName.lastIndexOf('.') + 1);
		return sfile;
	}

	public static String splitPreFileName(String fileName) {
		if (fileName == null)
			return null;	
		int pos = fileName.lastIndexOf('.');
		
		return fileName.substring(0, pos==-1?0:pos);
	}

	public static String splitPostFileName(String fileName) {
		if (fileName == null)
			return null;	
		int pos = fileName.lastIndexOf('.');
		return fileName.substring( (pos==-1?0:pos) + 1);
	}

	public static String toDownloadFileName(String s) {
		if (s == null)
			return s;
		try {
			s = new String(s.getBytes("GBK"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	public static String fromGBKtoUTF8(String s) {
		if (s == null)
			return s;
		try {
			s = new String(s.getBytes("GBK"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {

					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * @return true 如果不是空串 例如 Null 惑 "" <br/>
	 *         false 如果是Null 或者 ""
	 */
	public static boolean isNotVoid(String str) {
		return isNotEmpty(str) && isNotBlank(str);
	}

	/**
	 * counts the number of occurrences of character c in a string.
	 * 
	 * @param str
	 * @param c
	 * @return int
	 */
	public static int countChar(String str, char c) {
		int start = -1;
		int count = 0;
		while (true) {
			if ((start = str.indexOf(c, start + 1)) == -1)
				return (count);
			count++;
		}
	}

	/**
	 * Add delimiters to a string. If the string itself contains the delimiter
	 * character, the character will be escaped by repeating the delimitter
	 * character.
	 * 
	 * @return The delimited String
	 * @param str
	 *            The String to delimit
	 * @param delimiter
	 */
	public static String delimit(String str, char delimiter) {
		if (delimiter == 0)
			return (str);

		StringBuffer buffer = new StringBuffer();
		buffer.append(delimiter);
		if (str != null) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == delimiter)
					buffer.append(delimiter);
				buffer.append(str.charAt(i));
			}
		}
		buffer.append(delimiter);
		return (buffer.toString());
	}

	public static String getFirstToken(final String path, final String separator) {
		if (path == null)
			return null;

		final int index = path.indexOf(separator);

		if (index == -1)
			return path;

		return path.substring(0, index);
	}

	public static String getLastToken(final String path, final String separator) {
		if (path == null)
			return null;

		final int index = path.lastIndexOf(separator);

		if (index == -1)
			return path;

		if (index + 1 >= path.length())
			return "";

		return path.substring(index + 1);
	}

	/**
	 * Checks if a String is empty, i.e. if the String is null or is the String
	 * containing white spaces characters.
	 * 
	 * @param str
	 *            The String to check.
	 * @return Returns <code>true</code> is the string is empty otherwise return
	 *         <code>false</code>.
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}

	/**
	 * <p>
	 * Converts a String to lower case
	 * </p>
	 * 
	 * <p>
	 * A <code>null</code> input String returns <code>null</code>.
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.lowerCase(null)  = null
	 * StringUtils.lowerCase("")    = ""
	 * StringUtils.lowerCase("aBc") = "abc"
	 * </pre>
	 * 
	 * @param str
	 *            the String to lower case, may be null
	 * @return the lower cased String, <code>null</code> if null String input
	 */
	public static String lowerCase(String str) {
		if (str == null) {
			return null;
		}
		return str.toLowerCase();
	}

	/**
	 * Returns a new string resulting from replacing all occurrences of oldStr
	 * in this string with newStr.
	 * 
	 * @param str
	 * @param oldStr
	 *            The old string
	 * @param newStr
	 *            the new string
	 * @return
	 */
	public static String replace(String str, String oldStr, String newStr) {
		if (str == null || str.length() == 0) {
			return str;
		}

		StringBuffer buffer = new StringBuffer();
		int pos = 0;
		int oldPos = 0;
		while ((pos = str.indexOf(oldStr, oldPos)) != -1) {
			buffer.append(str.substring(oldPos, pos));
			buffer.append(newStr);
			oldPos = pos + oldStr.length();
		}

		buffer.append(str.substring(oldPos, str.length()));

		return buffer.toString();
	}

	/**
	 * 人民币转成大写
	 * 
	 * @param value
	 * @return String
	 */
	public static String hangeToBig(double value) {
		char[] hunit = { '拾', '佰', '仟' }; // 段内位置表示
		char[] vunit = { '万', '亿' }; // 段名表示
		char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' }; // 数字表示
		long midVal = (long) (value * 100); // 转化成整形
		String valStr = String.valueOf(midVal); // 转化成字符串

		String head = valStr.substring(0, valStr.length() - 2); // 取整数部分
		String rail = valStr.substring(valStr.length() - 2); // 取小数部分

		String prefix = ""; // 整数部分转化的结果
		String suffix = ""; // 小数部分转化的结果
		// 处理小数点后面的数
		if (rail.equals("00")) { // 如果小数部分为0
			suffix = "整";
		} else {
			suffix = digit[rail.charAt(0) - '0'] + "角"
					+ digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
		}
		// 处理小数点前面的数
		char[] chDig = head.toCharArray(); // 把整数部分转化成字符数组
		char zero = '0'; // 标志'0'表示出现过0
		byte zeroSerNum = 0; // 连续出现0的次数
		for (int i = 0; i < chDig.length; i++) { // 循环处理每个数字
			int idx = (chDig.length - i - 1) % 4; // 取段内位置
			int vidx = (chDig.length - i - 1) / 4; // 取段位置
			if (chDig[i] == '0') { // 如果当前字符是0
				zeroSerNum++; // 连续0次数递增
				if (zero == '0') { // 标志
					zero = digit[0];
				} else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					zero = '0';
				}
				continue;
			}
			zeroSerNum = 0; // 连续0次数清零
			if (zero != '0') { // 如果标志不为0,则加上,例如万,亿什么的
				prefix += zero;
				zero = '0';
			}
			prefix += digit[chDig[i] - '0']; // 转化该数字表示
			if (idx > 0)
				prefix += hunit[idx - 1];
			if (idx == 0 && vidx > 0) {
				prefix += vunit[vidx - 1]; // 段结束位置应该加上段名如万,亿
			}
		}

		if (prefix.length() > 0)
			prefix += '圆'; // 如果整数部分存在,则有圆的字样
		return prefix + suffix; // 返回正确表示
	}

	/**
	 * 人民币小写转换成大写
	 * 
	 * @param s
	 *            人民币小写(比如：12043000.01)
	 * @return 人民币大写(比如：壹仟贰佰零肆万叁仟元零壹分)
	 */
	public static String getNumberToRMB(String s) {
		if (s == null || s.trim().length() == 0) {
			return s;
		}

		StringBuilder rmbChinese = new StringBuilder();
		// 小数点位置
		int xsdwz = s.indexOf(".");
		// 整数部分
		String integral = "";
		// 角分部分
		String decimal = "";
		String[] wy = {};
		int xh = 0;
		String prefix = ""; // 整数部分转化的结果
		String suffix = ""; // 小数部分转化的结果

		if (xsdwz >= 0) {
			integral = s.substring(0, xsdwz);
			if (!integral.equals("")) {
				if (Double.parseDouble(integral) == 0) {
					integral = "";
				}
			}
			decimal = s.substring(xsdwz + 1, s.length());
			// for(int i=0;i<new)
			if (decimal.length() < 2) {
				decimal += "0";
			}
		} else {
			integral = s;
			decimal = "";
			// new2="00";
		}
		if (integral.length() > 0) {
			if (integral.substring(0, 1).equals("-")
					|| integral.substring(0, 1).equals("+")) {
				if (integral.substring(0, 1).equals("-")) {
					rmbChinese.append("负");
				}
				// 去掉前面的正、负符号
				integral = integral.substring(1, integral.length());
			}
		}

		if (integral.length() % 4 == 0) {
			xh = integral.length() / 4;
			// wy = new String[new1.length() / 4];
		} else {
			xh = integral.length() / 4 + 1;
			// wy = new String[new1.length() / 4 + 1];
		}
		wy = new String[xh];
		for (int i = 0; i < xh; i++) {
			if ((i + 1) * 4 <= integral.length()) {
				wy[i] = integral.substring(integral.length() - (i + 1) * 4,
						integral.length() - i * 4);
			} else {
				wy[i] = integral.substring(0, integral.length() % 4);
			}
			// System.out.println(wy);
		}

		if (integral.length() > 0 && Integer.parseInt(decimal) > 9) {
			rmbChinese.append(getDxZs(integral, 1, wy));
			rmbChinese.append(getDxJf(decimal));
		} else if (integral.length() > 0
				&& (Integer.parseInt(decimal) > 0 && Integer.parseInt(decimal) <= 9)) {
			rmbChinese.append(getDxZs(integral, 3, wy));
			rmbChinese.append(getDxJf(decimal));
		} else if (integral.length() > 0 && Integer.parseInt(decimal) == 0) {
			rmbChinese.append(getDxZs(integral, 2, wy));
		} else if (integral.length() == 0 && Integer.parseInt(decimal) > 0) {
			rmbChinese.append(getDxJf(decimal));
		}
		return rmbChinese.toString();
	}

	/**
	 * 获得大写整数部分
	 * 
	 * @param s
	 * @param i1
	 * @param wy
	 * @return
	 */
	private static String getDxZs(String s, int i1, String[] wy) {
		StringBuilder dxzs = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (Integer.parseInt(s.substring(i, 1 + i)) > 0) {
				if (i > 0 && i < s.length() - 1) {
					if (Integer.parseInt(s.substring(i - 1, i)) == 0) {
						dxzs.append("零");
						dxzs.append(getHanZi(Integer.parseInt(s.substring(i,
								i + 1))));
						dxzs.append(getWeiShu(s.length() - i));
					} else {
						dxzs.append(getHanZi(Integer.parseInt(s.substring(i,
								i + 1))));
						dxzs.append(getWeiShu(s.length() - i));
					}
				} else if (i == s.length() - 1) {// && i!=0) {
					if (i != 0 && Integer.parseInt(s.substring(i - 1, i)) == 0) {
						dxzs.append("零");
					}
					if (i1 == 1) {
						dxzs.append(getHanZi(Integer.parseInt(s.substring(i,
								i + 1))));
						dxzs.append(getWeiShu(s.length() - i));
					} else if (i1 == 2) {
						dxzs.append(getHanZi(Integer.parseInt(s.substring(i,
								i + 1))));
						dxzs.append(getWeiShu(s.length() - i));
						dxzs.append("整");
					} else if (i1 == 3) {
						dxzs.append(getHanZi(Integer.parseInt(s.substring(i,
								i + 1))));
						dxzs.append(getWeiShu(s.length() - i));
						dxzs.append("零");
					}
				} else if (i == 0) { // && i != s.length() - 1) {
					dxzs.append(getHanZi(Integer
							.parseInt(s.substring(i, i + 1))));
					dxzs.append(getWeiShu(s.length() - i));
				}
			} else if (Integer.parseInt(s.substring(i, i + 1)) == 0) {
				if (i > 0 && i < s.length() - 1) {
					if (s.length() - i == 9) {
						if (Integer.parseInt(wy[2]) != 0) {
							dxzs.append("亿");
						}
					} else if (s.length() - i == 5) {
						if (Integer.parseInt(wy[1]) != 0) {
							dxzs.append("万");
						}
					}
				} else if (i > 0 && i == s.length() - 1) {
					if (i1 == 1) {
						dxzs.append("元零");
					} else if (i1 == 2) {
						dxzs.append("元整");
					} else if (i1 == 3) {
						dxzs.append("元零");
					}
				}
			}
		}
		return dxzs.toString();
	}

	/**
	 * 获得大写角分部分
	 * 
	 * @param s
	 * @return
	 */
	private static String getDxJf(String s) {
		StringBuilder dxjf = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (Integer.parseInt(s.substring(i, i + 1)) != 0) {
				dxjf.append(getHanZi(Integer.parseInt(s.substring(i, i + 1))));
				dxjf.append(getJiaFen(i + 1));
			} else if (Integer.parseInt(s.substring(i, i + 1)) == 0 && i == 1) {
				dxjf.append("整");
			}
		}
		return dxjf.toString();
	}

	/**
	 * 获得角、分
	 * 
	 * @param s
	 * @return
	 */
	private static String getJiaFen(int s) {
		String hz = "";
		if (s == 1) {
			hz = "角";
		} else if (s == 2) {
			hz = "分";
		}
		return hz;
	}

	/**
	 * 获得数字的大写汉字
	 * 
	 * @param s
	 *            0～9的整数
	 * @return 零～玖的汉字
	 */
	private static String getHanZi(int s) {
		String[] hzDigit = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		return hzDigit[s];
	}

	/**
	 * 获得位数
	 * 
	 * @param s
	 * @return
	 */
	private static String getWeiShu(int s) {
		String hz = "";
		if (s == 1) {
			hz = "元";
		} else if (s == 2) {
			hz = "拾";
		} else if (s == 3) {
			hz = "佰";
		} else if (s == 4) {
			hz = "仟";
		} else if (s == 5) {
			hz = "万";
		} else if (s == 6) {
			hz = "拾";
		} else if (s == 7) {
			hz = "佰";
		} else if (s == 8) {
			hz = "仟";
		} else if (s == 9) {
			hz = "亿";
		} else if (s == 10) {
			hz = "拾";
		} else if (s == 11) {
			hz = "佰";
		} else if (s == 12) {
			hz = "仟";
		}
		return hz;
	}
	
	public static String generateUUIDSring(){
		UUID u  = UUID.randomUUID();
		return u.toString();
	}

}
