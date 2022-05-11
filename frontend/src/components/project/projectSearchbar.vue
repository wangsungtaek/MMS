<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card">
        <div class="card-body align-middle">
          
          <div class="row justify-content-end">

            <!-- 검색 조건 -->
            <div class="col-lg-3">
              <b-form-input v-model="searchText" placeholder="프로젝트명을 입력하세요."></b-form-input>
            </div>

            <!-- 검색 버튼 -->
            <div class="col-lg-1">
              <b-button @click="searchProejct" variant="primary" id="searchBtn">
                <i class="fas fa-search align-middle mr-2"></i>
                검색
              </b-button>
            </div>

          </div>

        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { projectMethods } from "@/state/helpers";

export default {
  components: {
  },
  data() {
    return {
      daterange: "",
      value: "",
      searchText: "",
    };
  },
  methods: {
    ...projectMethods,

    // 프로젝트 검색
    searchProejct() {
      this.FETCH_PROJECT({ searchText: this.searchText });
    }
  }
};
</script>
<style>
.mx-input {
  height: 38px;
}
</style>