﻿// axios 요청자리
const posts = [
	{ id: 1, title: '제목1', content: '내용1', createdAt: '2023-04-27' },
	{ id: 2, title: '제목2', content: '내용2', createdAt: '2023-04-28' },
	{ id: 3, title: '제목3', content: '내용3', createdAt: '2023-04-29' },
	{ id: 4, title: '제목4', content: '내용4', createdAt: '2023-04-30' },
	{ id: 5, title: '제목5', content: '내용5', createdAt: '2023-05-01' },
];

export function getPosts() {
	return posts;
}
