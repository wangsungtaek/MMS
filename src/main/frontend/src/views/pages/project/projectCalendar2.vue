<script>
import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";

export default {
  page: {
    meta: [{ name: "project calendar" }]
  },
  components: { Layout, PageHeader },
  data() {
    return {
      title: "프로젝트 캘린더",
      items: [
        {
          text: "프로젝트",
          href: "/"
        },
        {
          text: "프로젝트 캘린더",
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