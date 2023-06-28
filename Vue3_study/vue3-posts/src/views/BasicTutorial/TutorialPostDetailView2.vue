<template>
	<div>
		<h2>{{ form.title }}</h2>
		<p>{{ form.content }}</p>
		<p class="text-muted">{{ form.createdAt }}</p>
		<hr class="my-4" />
		<div class="row">
			<div class="col-auto">
				<button class="btn btn-outline-dark">이전글</button>
			</div>
			<div class="col-auto">
				<button class="btn btn-outline-dark">다음글</button>
			</div>
			<div class="col-auto me-auto"></div>
			<div class="col-auto">
				<button class="btn btn-outline-dark" @click="goListPage">목록</button>
			</div>
			<div class="col-auto">
				<button class="btn btn-outline-primary" @click="goEditPage">
					수정
				</button>
			</div>
			<div class="col-auto">
				<button class="btn btn-outline-danger">삭제</button>
			</div>
		</div>
	</div>
</template>

<script setup>
import { useRouter, useRoute } from 'vue-router';
import { getPostById } from '@/api/posts';
// import { ref } from 'vue';
import { reactive } from 'vue';

const route = useRoute();
const router = useRouter();
// 라우트 속성에 props 속성 적용 안 할 때
const id = route.params.id;

// 1. form을 ref() 로 선언하면
// 장) 객체 할당 가능, 일관성 유지 가능
// 단) form.value.title  ,  form.value.content
// -------------------------------------------
// const form = ref({});

// const fetchPost = () => {
// 	const data = getPostById(id);
// 	form.value = { ...data };
// };

// ===========================================
// 2. form 을 reactive() 로 선언하면
// 장) form.title   ,   form.content
// 단) 객체 할당 불가능
// --------------------------------------------
const form = reactive({});

const fetchPost = () => {
	const data = getPostById(id);
	form.title = data.title;
	form.content = data.content;
};

fetchPost();

const goListPage = () => router.push({ name: 'PostList' });
const goEditPage = () => router.push({ name: 'PostEdit', params: { id } });
</script>

<style lang="scss" scoped></style>
