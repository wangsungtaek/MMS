<template>
  <Layout>
    <PageHeader :title="title" :items="items" />
    <!-- searchBar -->
    <naverSearchbar/>

    <!-- alert -->
    <b-alert show variant="secondary text-center">
      <i class="mdi mdi-14px mdi-alert-octagon"></i>
      프로젝트에 신청한 모든 리뷰어를 최신 활동순으로 검색할 수 있습니다.
    </b-alert>

    <!-- dataList -->
    <naverDataList/>
  </Layout>
</template>

<script>
import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";
import naverSearchbar from '../../../components/reviewer/naverSearchbar.vue';
import naverDataList from '../../../components/reviewer/naverDataList.vue';


export default {
  page: {
    meta: [{ name: "reviewer naver" }]
  },
  components: { 
    Layout,
    PageHeader,
    naverSearchbar,
    naverDataList
  },
  data() {
    return {
      title: "리뷰어 목록 - 네이버",
      items: [
        {
          text: "리뷰어",
          href: "/"
        },
        {
          text: "네이버",
          active: true
        }
      ]
    };
  }
};
</script>
