<template>
  <Layout>
    <PageHeader :title="title" :items="items" />
    <!-- searchBar -->
    <instagramSearchbar/>

    <!-- alert -->
    <b-alert show variant="secondary text-center">
      <i class="mdi mdi-14px mdi-alert-octagon"></i>
      프로젝트에 신청한 모든 리뷰어를 최신 활동순으로 검색할 수 있습니다.
    </b-alert>

    <!-- dataList -->
    <instagramDataList/>
  </Layout>
</template>
<script>
import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";
import instagramSearchbar from '../../../components/reviewer/instagramSearchbar.vue';
import instagramDataList from '../../../components/reviewer/instagramDataList.vue';

export default {
  page: {
    meta: [{ name: "reviewer instagram" }]
  },
  components: {
    Layout,
    PageHeader,
    instagramSearchbar,
    instagramDataList
  },
  data() {
    return {
      title: "리뷰어 목록 - 인스타그램",
      items: [
        {
          text: "리뷰어",
          href: "/reviewer/all"
        },
        {
          text: "인스타그램",
          active: true
        }
      ]
    };
  }
};
</script>
