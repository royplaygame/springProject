package com.hy.ly.meeting;

import org.springframework.stereotype.Component;

@Component
public class MeetingPlaceImpl implements MeetingPlace {

	@Override
	public void singer(String name) {
		//1. 演唱会开幕式
		//int k=10/0;
		//System.out.println(k);
		System.out.println(name+ " 歌手演唱。。。。。");
		//2. 演唱会闭幕式

	}

	@Override
	public void football(String name) {
		//1. 足球比赛开幕式
		System.out.println(name+ " 足球比赛。。。。。");
		//2. 足球比赛闭幕式

	}

	@Override
	public void party(String name) {
		//1. party开幕致辞
		System.out.println(name+ " 进行party。。。。。");
		//2. party闭幕致辞

	}

}
