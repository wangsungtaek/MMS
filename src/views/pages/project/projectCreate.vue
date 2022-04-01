<script>
import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";

export default {
  page: {
    meta: [{ name: "project create" }]
  },
  components: { Layout, PageHeader },
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
  </Layout>
</template>