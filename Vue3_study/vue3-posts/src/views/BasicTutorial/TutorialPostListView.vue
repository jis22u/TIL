<template>
	<div>
		<h2>게시글 목록</h2>
		<hr class="my-4" />
		<div class="row g-3">
			<div v-for="post in posts" :key="post.id" class="col-4">
				<PostItem
					:title="post.title"
					:content="post.content"
					:created-at="post.createdAt"
					@click="goPage(post.id)"
				></PostItem>
			</div>
		</div>
	</div>
</template>

<script setup>
import PostItem from '@/components/posts/PostItem.vue';
import { getPosts } from '@/api/posts';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const posts = ref([]);

// post 객체 가져오기
const fetchPosts = () => {
	posts.value = getPosts();
};
fetchPosts();

// 상세조회 페이지로 이동
const goPage = id => {
	// 1) 리터럴 문자열 경로로 이동
	// router.push(`/posts/${id}`);

	// 2) 객체(이름을 가지는 라우트)로 이동
	//    아래와 같이 path 를 지정하면 url 창에 아래와 같은 주소가 찍힌다. (상세페이지로 이동할 때)
	//    http://localhost:5173/posts/1?searchText=false#world
	router.push({
		name: 'PostDetail',
		params: {
			id,
		},
		query: {
			searchText: 'false',
		},
		hash: '#world',
	});
};
</script>

<style lang="scss" scoped></style>
