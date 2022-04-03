<template>
<!-- 프로젝트 리스트 -->
<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-body">

        <div class="table-responsive">
          <b-table
            class="table-centered"
            :items="projectList"
            :fields="projectHeader"
            responsive="sm"
            :per-page="perPage"
            :current-page="currentPage"
            :sort-by.sync="sortBy"
            :sort-desc.sync="sortDesc"
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

</template>
<script>
export default {
  components: {
  },
  data() {
    return {
      projectHeader: [
        { key: "no", label: "순번", },
        { key: "projectName", label: "프로젝트명" },
        { key: "startDate", sortable: true, label: "시작 날짜" },
        { key: "endDate", sortable: true, label: "종료 날짜" },
        { key: "state", sortable: true, label: "상태" },
        { key: "action", sortable: false, label: "" }
      ],
      projectList: [
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
      perPage: 10,
      sortBy: "no",
      sortDesc: false,  
    };
  },
  computed: {
    /**
     * Total no. of records
     */
    rows() {
      return this.projectList.length;
    }
  },
};
</script>