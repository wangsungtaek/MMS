<template>
  <Layout>
    <PageHeader :title="title" :items="items" />
    <allSearchbar/>

    <!-- alert -->
    <b-alert show variant="secondary text-center">
      <i class="mdi mdi-14px mdi-alert-octagon"></i>
      프로젝트에 신청한 모든 리뷰어를 최신 활동순으로 검색할 수 있습니다.
    </b-alert>

    <allDataList/>
  </Layout>
</template>
<script>

import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";
import allSearchbar from '../../../components/reviewer/allSearchbar.vue';
import allDataList from '../../../components/reviewer/allDataList.vue';


export default {
  page: {
    meta: [{ name: "reviewer all" }]
  },
  components: { 
    Layout,
    PageHeader,
    allSearchbar,
    allDataList
     },
  data() {
    return {
      title: "리뷰어 통합 검색",
      items: [
        {
          text: "리뷰어",
          href: "/reviewer/all"
        },
        {
          text: "리뷰어 통합 검색",
          active: true
        }
      ]
    };
  }
};
</script>