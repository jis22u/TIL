<template>
	<div>
		<h2>게시글 상세</h2>
		<hr class="my-4" />
		<!-- 동적 라우팅 시 세미콜론 뒤에 오는 값(파라미터)을 route 객체의 params라는 것으로 받음 -->
		<!-- http://localhost:5173/posts/dkjflk -->
		<p>params: {{ $route.params }}</p>
		<!-- http://localhost:5173/posts/dkjflk?searchText=Vue3바이블 -->
		<p>query : {{ $route.query.searchText }}</p>
		<!-- http://localhost:5173/posts/dkjflk#hashvalue -->
		<p>hash : {{ $route.hash }}</p>
	</div>
</template>

<script setup></script>

<style lang="scss" scoped></style>
