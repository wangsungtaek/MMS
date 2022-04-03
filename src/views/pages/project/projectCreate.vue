<script>
import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";
import projectForm from '../../../components/project/projectForm.vue';


export default {
  page: {
    meta: [{ name: "project create" }]
  },
  components: { 
    Layout,
    PageHeader,
    projectForm
  },
  data() {
    return {
      title: "프로젝트 생성",
      items: [
        {
          text: "프로젝트",
          href: "/"
        },
        {
          text: "프로젝트 생성",
          active: true
        }
      ]
    };
  }
};
</script>

<template>
  <Layout>
    <PageHeader :title="title" :items="items" />
    <projectForm/>
  </Layout>
</template>