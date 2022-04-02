<script>
import DatePicker from "vue2-datepicker";

export default {
  components: {
    DatePicker,
  },
  data() {
    return {
      daterange: "",
      value: "",
      selected: "",
      searchText: "",
      options: [
        "제목",
        "번호",
        "태그",
      ],
      title: "Orders",
      items: [
        {
          text: "Ecommerce"
        },
        {
          text: "Orders",
          active: true
        }
      ],
      ordersData: [
        { no: "#1", projectName: "마운트뷰 모니터암 신제품 리뷰 인플루언서 모집", startDate: "2022-02-05", endDate: "2022-03-01", state: "진행중", action: "" },
        { no: "#2", projectName: "마운트뷰 모니터암 신제품 리뷰 인플루언서 모집", startDate: "2022-02-05", endDate: "2022-03-01", state: "시작전", action: "" },
        { no: "#3", projectName: "마운트뷰 모니터암 신제품 리뷰 인플루언서 모집", startDate: "2022-02-05", endDate: "2022-03-01", state: "완료", action: "" },
        { no: "#4", projectName: "마운트뷰 모니터암 신제품 리뷰 인플루언서 모집", startDate: "2022-02-05", endDate: "2022-03-01", state: "진행중", action: "" },
        { no: "#5", projectName: "마운트뷰 모니터암 신제품 리뷰 인플루언서 모집", startDate: "2022-02-05", endDate: "2022-03-01", state: "완료", action: "" },
        { no: "#6", projectName: "마운트뷰 모니터암 신제품 리뷰 인플루언서 모집", startDate: "2022-02-05", endDate: "2022-03-01", state: "완료", action: "" },
        { no: "#7", projectName: "마운트뷰 모니터암 신제품 리뷰 인플루언서 모집", startDate: "2022-02-05", endDate: "2022-03-01", state: "완료", action: "" },
        { no: "#8", projectName: "마운트뷰 모니터암 신제품 리뷰 인플루언서 모집", startDate: "2022-02-05", endDate: "2022-03-01", state: "완료", action: "" },
        { no: "#9", projectName: "마운트뷰 모니터암 신제품 리뷰 인플루언서 모집", startDate: "2022-02-05", endDate: "2022-03-01", state: "완료", action: "" },
        { no: "#10", projectName: "마운트뷰 모니터암 신제품 리뷰 인플루언서 모집", startDate: "2022-02-05", endDate: "2022-03-01", state: "완료", action: "" },
        { no: "#11", projectName: "마운트뷰 모니터암 신제품 리뷰 인플루언서 모집", startDate: "2022-02-05", endDate: "2022-03-01", state: "완료", action: "" },
        { no: "#12", projectName: "마운트뷰 모니터암 신제품 리뷰 인플루언서 모집", startDate: "2022-02-05", endDate: "2022-03-01", state: "완료", action: "" },
        { no: "#13", projectName: "마운트뷰 모니터암 신제품 리뷰 인플루언서 모집", startDate: "2022-02-05", endDate: "2022-03-01", state: "완료", action: "" },
        { no: "#14", projectName: "마운트뷰 모니터암 신제품 리뷰 인플루언서 모집", startDate: "2022-02-05", endDate: "2022-03-01", state: "완료", action: "" },

      ],
      totalRows: 1,
      currentPage: 1,
      perPage: 7,
      sortBy: "no",
      sortDesc: false,
      fields: [
        { key: "no", label: "순번", },
        { key: "projectName", label: "프로젝트명" },
        { key: "startDate", sortable: true, label: "시작 날짜" },
        { key: "endDate", sortable: true, label: "종료 날짜" },
        { key: "state", sortable: true, label: "상태" },
        { key: "action", sortable: false, label: "" }
      ]
    };
  },
  computed: {
    /**
     * Total no. of records
     */
    rows() {
      return this.ordersData.length;
    }
  },
  mounted() {
    // Set the initial number of items
    this.totalRows = this.ordersData.length;
  },
  methods: {

  }
};
</script>

<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card">
        <div class="card-body align-middle">
          <div class="row">

            <!-- 검색 기간 -->
            <div class="col-lg-1 my-auto text-right">
              <label for="" class="m-0">기간</label>
            </div>
            <div class="col-lg-3">
              <date-picker v-model="daterange" range append-to-body></date-picker>
            </div>
            
            <div class="col-lg-4">
            </div>

            <!-- 검색 조건 -->
            <div class="col-lg-1">
              <b-form-select v-model="selected" :options="options"></b-form-select>
            </div>
            <div class="col-lg-2">
              <b-form-input v-model="searchText" placeholder="검색어를 입력하세요."></b-form-input>
            </div>

            <div class="col-lg-1">
              <b-button variant="primary" id="searchBtn">
                <i class="fas fa-search align-middle mr-2"></i>
                검 색
              </b-button>
            </div>
          </div>
        </div>
      </div>

      <!-- 프로젝트 리스트 -->
      <div class="row">
      <div class="col-lg-12">
        <div class="card">
          <div class="card-body">

            <div class="table-responsive">
              <b-table
                class="table-centered"
                :items="ordersData"
                :fields="fields"
                responsive="sm"
                :per-page="perPage"
                :current-page="currentPage"
                :sort-by.sync="sortBy"
                :sort-desc.sync="sortDesc"
                :head-variant="dark"
              >
                <template v-slot:cell(state)="row">
                  <div
                    class="badge font-size-12 text-center"
                    :class="{'badge-soft-danger': `${row.value}` === '시작전',
                        'badge-soft-success': `${row.value}` === '완료',
                        'badge-soft-warning': `${row.value}` === '진행중'}"
                  >{{ row.value }}</div>
                </template>
                <template v-slot:cell(invoice)>
                  <button class="btn btn-light btn-rounded">
                    Invoice
                    <i class="mdi mdi-download ml-2"></i>
                  </button>
                </template>
                <template v-slot:cell(action)>
                  <a
                    href="javascript:void(0);"
                    class="mr-3 text-primary"
                    v-b-tooltip.hover
                    title="Edit"
                  >
                    <i class="mdi mdi-pencil font-size-18"></i>
                  </a>
                  <a
                    href="javascript:void(0);"
                    class="text-danger"
                    v-b-tooltip.hover
                    title="Delete"
                  >
                    <i class="mdi mdi-trash-can font-size-18"></i>
                  </a>
                </template>
              </b-table>
            </div>
            <div class="row">
              <div class="col">
                <div class="dataTables_paginate paging_simple_numbers float-right">
                  <ul class="pagination pagination-rounded mb-0">
                    <!-- pagination -->
                    <b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage"></b-pagination>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    </div>
  </div>
</template>
<style>
.mx-input {
  height: 38px;
}
</style>