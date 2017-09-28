package com.hy.ly.meeting;

public class MeetingPlaceImplAll implements MeetingPlace {

	@Override
	public void singer(String name) {
		// 1. 演唱会开幕式
		System.out.println(name +" 开幕式开始。。。。。");
		
		System.out.println(name + " 歌手演唱。。。。。");
		
		// 2. 演唱会闭幕式
		System.out.println(name +" 完美闭幕。。。。。");

	}

	@Override
	public void football(String name) {
		// 1. 足球比赛开幕式
		System.out.println(name +" 开幕式开始。。。。。");
		
		System.out.println(name + " 足球比赛。。。。。");
		
		// 2. 足球比赛闭幕式
		System.out.println(name +" 完美闭幕。。。。。");
	}

	@Override
	public void party(String name) {
		// 1. party开幕致辞
		System.out.println(name +" 开幕式开始。。。。。");
		
		System.out.println(name + " 进行party。。。。。");
		
		// 2. party闭幕致辞
		System.out.println(name +" 完美闭幕。。。。。");
	}

}
