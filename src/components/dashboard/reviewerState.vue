<template>
  <div class="row">
    <div class="col-md-3" v-for="(data, index) in statData" :key="index">
      <div class="card">
        <div class="card-body">
          <div class="media">
            <div class="media-body overflow-hidden">
              <p class="text-truncate font-size-14 mb-2">{{data.title}}</p>
              <h4 class="mb-0">{{data.value}}</h4>
            </div>
            <div :class="`${data.color}`">
              <i :class="`${data.icon} font-size-24`"></i>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- end row -->
</template>

<script>
export default {
  data() {
    return {
      statData: [
        {
          title: "총 리뷰어",
          icon: "ri-stack-line",
          value: "100",
          color: "text-primary"
        },
        {
          title: "네이버 리뷰어",
          icon: "ri-stack-line",
          value: "52",
          color: "text-success"
        },
        {
          title: "인스타그램 리뷰어",
          icon: "ri-stack-line",
          value: "10",
          color: "text-danger"
        },
      ]
    };
  }
};
</script>
