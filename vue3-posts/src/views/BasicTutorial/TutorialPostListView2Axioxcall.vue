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
    <hr class="my-4" />
    <AppCard>
      <PostDetailView :id="1"></PostDetailView>
    </AppCard>
  </div>
</template>

<script setup>
import PostItem from '@/components/posts/PostItem.vue'
import PostDetailView from '@/views/posts/PostDetailView.vue'
import AppCard from '@/components/AppCard.vue'
import { getPosts } from '@/api/posts'
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const posts = ref([])

// post 객체 가져오기
// 1) async await 문법으로
const fetchPost = async () => {
  // 구조 분해 할당 방법1
  // response 안에 data만 가져옴
  const { data } = await getPosts()
  posts.value = data
  // 구조 분해 할당 방법2
  //   ({ data: posts.value } = await getPosts())
}
fetchPost()

// 2) promise 문법으로
// const fetchPost = () => {
//   getPosts()
//     .then((response) => {
//       console.log('response: ', response)
//     })
//     .catch((error) => {
//       console.log('error: ', error)
//     })
// }

// 상세조회 페이지로 이동
const goPage = (id) => {
  // 2) 객체(이름을 가지는 라우트)로 이동
  router.push({
    name: 'PostDetail',
    params: {
      id
    }
  })
}
</script>

<style lang="scss" scoped></style>
