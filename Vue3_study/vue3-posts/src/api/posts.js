import { posts } from '.';

export function getPosts(params) {
	return posts.get('/', { params });
}

export function getPostById(id) {
	// return posts.get(`/${id}`); > id 값이 숫자형이면
	return posts.get(id); //  > id 값이 문자열이면
}

export function createPost(data) {
	return posts.post('', data);
}

export function updatePost(id, data) {
	return posts.put(id, data);
}

export function deletePost(id) {
	return posts.delete(`/${id}`);
}
