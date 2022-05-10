<script>
import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";
import projectSearchbar from '../../../components/project/projectSearchbar.vue';
import projectDataList from '../../../components/project/projectDataList.vue';

export default {
  page: {
    meta: [{ name: "project list" }]
  },
  components: { 
    Layout, 
    PageHeader,
    projectSearchbar,
    projectDataList
  },
  data() {
    return {
      title: "프로젝트 목록",
      items: [
        {
          text: "프로젝트",
          href: "/project/list"
        },
        {
          text: "프로젝트 목록",
          active: true
        }
      ],
    };
  },
};
</script>

<template>
  <Layout>
    <PageHeader :title="title" :items="items" />
      <projectSearchbar/>
      <projectDataList/>
  </Layout>
</template>