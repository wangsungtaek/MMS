<script>
export default {
  methods: {
    initFullScreen() {
      document.body.classList.toggle("fullscreen-enable");
      if (
        !document.fullscreenElement &&
        /* alternative standard method */ !document.mozFullScreenElement &&
        !document.webkitFullscreenElement
      ) {
        // current working methods
        if (document.documentElement.requestFullscreen) {
          document.documentElement.requestFullscreen();
        } else if (document.documentElement.mozRequestFullScreen) {
          document.documentElement.mozRequestFullScreen();
        } else if (document.documentElement.webkitRequestFullscreen) {
          document.documentElement.webkitRequestFullscreen(
            Element.ALLOW_KEYBOARD_INPUT
          );
        }
      } else {
        if (document.cancelFullScreen) {
          document.cancelFullScreen();
        } else if (document.mozCancelFullScreen) {
          document.mozCancelFullScreen();
        } else if (document.webkitCancelFullScreen) {
          document.webkitCancelFullScreen();
        }
      }
    },
    toggleMenu() {
      let element = document.getElementById("topnav-menu-content");
      element.classList.toggle("show");
    },
  },
  mounted() {
    document.body.setAttribute("data-topbar", "light");
    document.body.setAttribute("data-layout-mode", "fluid");
    document.body.removeAttribute("data-layout-size");
  },
};
</script>

<template>
  <header id="page-topbar">
    <div class="navbar-header">

      <div class="d-flex">
        <!-- LOGO -->
        <div class="navbar-brand-box">
          <a href="/" class="logo logo-dark">
            <span class="logo-sm">
              <img src="@/assets/images/logo-sm-dark.png" alt height="22" />
            </span>
            <span class="logo-lg">
              <img src="@/assets/images/logo-dark.png" alt height="20" />
            </span>
          </a>
        </div>

        <!-- 메뉴 드롭다운 -->
        <button
          type="button"
          class="btn btn-sm px-3 font-size-24 d-lg-none header-item"
          data-toggle="collapse"
          @click="toggleMenu"
        >
          <i class="ri-menu-2-line align-middle"></i>
        </button>

      </div>

      
      <div class="d-flex">

        <!-- 풀 스크린 -->
        <div class="dropdown d-none d-lg-inline-block ml-1">
          <button
            type="button"
            class="btn header-item noti-icon waves-effect"
            data-toggle="fullscreen"
            @click="initFullScreen"
          >
            <i class="ri-fullscreen-line"></i>
          </button>
        </div>

        <!-- 사용자 프로필 -->
        <b-dropdown
          right
          variant="black"
          toggle-class="header-item"
          class="d-inline-block user-dropdown"
        >
          <template v-slot:button-content>
            <span class="d-none d-xl-inline-block ml-1">
              admin
            </span>
            <i class="mdi mdi-chevron-down d-none d-xl-inline-block"></i>
          </template>

          <!-- item-->
          <a class="dropdown-item" href="#">
            <i class="ri-user-line align-middle mr-1"></i>
            프로필
          </a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item text-danger" href="/logout">
            <i class="ri-shut-down-line align-middle mr-1 text-danger"></i>
            로그아웃
          </a>
        </b-dropdown>
      </div>
    </div>
  </header>
</template>