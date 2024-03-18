package com.peisia.c.site.display;

import com.peisia.c.util.Cw;

public class DispSite {
	static private String SITE_NAME = "Psisia";
	static private String VERSION = "0.1";
	static private String FEAT = "kwon";
	static public void entranceTitle() {
		Cw.line();
		Cw.dot();
		Cw.space(22);
		Cw.w(SITE_NAME);
		Cw.w(VERSION);
		Cw.w(FEAT);
		Cw.space(22);
		Cw.dot();
		Cw.wn();
		Cw.line();
	}
}
