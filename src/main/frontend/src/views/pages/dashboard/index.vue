<template>
  <Layout>
    <PageHeader :title="title" :items="items" />
    <div class="row">
      <div class="col-xl-12">
        <projectState />
        <reviewerState />
      </div>
    </div>
  </Layout>
</template>

<script>
import Layout from "../../layouts/main";
import PageHeader from "@/components/page-header";

import projectState from '@/components/dashboard/projectState.vue';
import reviewerState from '@/components/dashboard/reviewerState.vue';

export default {
  components: {
    Layout,
    PageHeader,
    projectState,
    reviewerState
  },
  data() {
    return {
      title: "대시보드",
      items: [
        {
          text: "MMS"
        },
        {
          text: "대시보드",
          active: true
        }
      ]
    };
  }
};
</script>
