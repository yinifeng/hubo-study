package com.hubo.string;

import java.util.prefs.Preferences;

public class StringDemo3 {
	public static void main(String[] args) {
		Preferences systemRoot = Preferences.systemRoot();
		System.out.println(systemRoot.toString());
		
		
		
		Preferences userRoot = Preferences.userRoot();
		System.out.println(userRoot.toString());
	}
}
