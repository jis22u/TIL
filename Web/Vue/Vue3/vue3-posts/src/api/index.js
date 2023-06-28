import axios from 'axios';

function create(baseURL, options) {
	const instance = axios.create(Object.assign({ baseURL }, options));
	return instance;
}

export const posts = create(`${import.meta.env.VITE_APP_API_URL}posts/`);
// development: http://localhost:5000/posts/   (개발 주소)
// produciton: http://localhost:5001/posts/    (운영 주소)

// export const comments = create('http://localhost:5000/comments/');
