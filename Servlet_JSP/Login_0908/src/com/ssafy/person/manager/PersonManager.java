package com.ssafy.person.manager;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.person.dto.Person;

public class PersonManager {
	private List<Person> personList;
	private PersonManager() {
		personList = new ArrayList<Person>();
	}
	private static PersonManager instance = new PersonManager();
	public static PersonManager getInstance() {
		return instance;
	}
	
	// 목록을 조회
	// 리스트를 배열로
	public Person[] getPersonList(){
		return personList.toArray(new Person[personList.size()]);
	}
	
	// 번호에 해당하는 사람을 조회
	public Person getPerson(int no) {
		for( Person p : personList ) {
			if( p.getNo() == no )
				return p;
		}
		return null;
	}
	
	// 사람을 추가
	public void addPerson(Person p) {
		personList.add(p);
	}
	
	// 사람을 수정
	public void updatePerson(Person p) {
		for(Person person : personList) {
			if(person.getNo() == p.getNo()) {
				person.setAge(p.getAge());
				person.setMsg(p.getMsg());
				person.setName(p.getName());
			}
		}
	}
	
	// 사람을 삭제
	public void deletePerson(int no) {
		Person p = this.getPerson(no);
		personList.remove(p);
	}
}