import { mapState, mapGetters, mapActions } from 'vuex'

export const authComputed = {
  ...mapState('auth', {
    currentUser: (state) => state.currentUser,
  }),
  ...mapGetters('auth', ['loggedIn']),
}

export const layoutComputed = {
  ...mapState('layout', {
    layoutType: (state) => state.layoutType,
    leftSidebarType: (state) => state.leftSidebarType,
    layoutWidth: (state) => state.layoutWidth,
    topbar: (state) => state.topbar,
    loader: (state) => state.loader
  })
}

export const projectComputed = {
  ...mapState('project', {
    projects: (state) => state.projects
  })
}

export const reviewerComputed = {
  ...mapState('reviewer', {
    blogerList: (state) => state.blogerList
  })
}

export const categoryComputed = {
  ...mapState('comCode', {
    categoryList: (state) => state.categoryList,
    categoryCombo: (state) => state.categoryCombo
  })
}

export const authMethods = mapActions('auth', ['logIn', 'logOut', 'register', 'resetPassword'])

export const layoutMethods = mapActions('layout', ['changeLayoutType', 'changeLayoutWidth', 'changeLeftSidebarType', 'changeTopbar', 'changeLoaderValue'])

export const authFackMethods = mapActions('authfack', ['login', 'registeruser', 'logout'])

export const notificationMethods = mapActions('notification', ['success', 'error', 'clear'])

export const projectMethods = mapActions('project', ['FETCH_PROJECT', 'CREATE_PROJECT'])
export const reviewerMethods = mapActions('reviewer', ['FATCH_BLOGER', 'CREATE_BLOGER', 'UPDATE_BLOGER', 'DELETE_BLOGER'])
export const categoryMethods = mapActions('comCode', ['FATCH_CATEGORY', 'CREATE_CATEGORY', 'DELETE_CATEGORY'])