import store from '@/state/store'

export default [
    {
        path: '/login',
        name: 'login',
        component: () => import('../views/pages/account/login'),
        meta: {
            beforeResolve(routeTo, routeFrom, next) {
                // If the user is already logged in
                if (store.getters['auth/loggedIn']) {
                    // Redirect to the home page instead
                    next({ name: 'home' })
                } else {
                    // Continue to the login page
                    next()
                }
            },
        },
    },
    {
        path: '/register',
        name: 'register',
        component: () => import('../views/pages/account/register'),
        meta: {
            beforeResolve(routeTo, routeFrom, next) {
                // If the user is already logged in
                if (store.getters['auth/loggedIn']) {
                    // Redirect to the home page instead
                    next({ name: 'home' })
                } else {
                    // Continue to the login page
                    next()
                }
            },
        },
    },
    {
        path: '/forgot-password',
        name: 'Forgot-password',
        component: () => import('../views/pages/account/forgot-password'),
        meta: {
            beforeResolve(routeTo, routeFrom, next) {
                // If the user is already logged in
                if (store.getters['auth/loggedIn']) {
                    // Redirect to the home page instead
                    next({ name: 'home' })
                } else {
                    // Continue to the login page
                    next()
                }
            },
        },
    },
    {
        path: '/logout',
        name: 'logout',
        meta: {
            authRequired: true,
            beforeResolve(routeTo, routeFrom, next) {
                if (process.env.VUE_APP_DEFAULT_AUTH === "firebase") {
                    store.dispatch('auth/logOut')
                } else {
                    store.dispatch('authfack/logout')
                }
                const authRequiredOnPreviousRoute = routeFrom.matched.some(
                    (route) => route.push('/login')
                )
                // Navigate back to previous page, or home as a fallback
                next(authRequiredOnPreviousRoute ? { name: 'home' } : { ...routeFrom })
            },
        },
    },
    {
        path: '/',
        name: 'home',
        meta: { authRequired: true },
        component: () => import('../views/pages/dashboard/index')
    },

    /**
     * Project
     */
    {
        path: '/project/list',
        name: 'Project-list',
        meta: { authRequired: true },
        component: () => import('../views/pages/project/projectList')
    },
    {
        path: '/project/calendar',
        name: 'Project-calendar',
        meta: { authRequired: true },
        component: () => import('../views/pages/project/projectCalendar')
    },
    {
        path: '/project/create',
        name: 'Project-create',
        meta: { authRequired: true },
        component: () => import('../views/pages/project/projectCreate')
    },
    {
        path: '/signupForm/:PROJECT_ID',
        name: 'signupForm',
        meta: { authRequired: false },
        component: () => import('../views/pages/project/signupForm'),
        props: true,
    },

    /**
     * Reviewer
     */
    {
        path: '/reviewer/all',
        name: 'Reviewer-all',
        meta: { authRequired: true },
        component: () => import('../views/pages/reviewer/reviewerAll')
    },
    {
        path: '/reviewer/facebook',
        name: 'Reviewer-facebook',
        meta: { authRequired: true },
        component: () => import('../views/pages/reviewer/reviewerFacebook')
    },
    {
        path: '/reviewer/instagram',
        name: 'Reviewer-instagram',
        meta: { authRequired: true },
        component: () => import('../views/pages/reviewer/reviewerInstagram')
    },
    {
        path: '/reviewer/naver',
        name: 'Reviewer-naver',
        meta: { authRequired: true },
        component: () => import('../views/pages/reviewer/reviewerNaver')
    },
    {
        path: '/reviewer/youtube',
        name: 'Reviewer-youtube',
        meta: { authRequired: true },
        component: () => import('../views/pages/reviewer/reviewerYoutube')
    },

    /**
     * Search
     */
    {
        path: '/search/instagram',
        name: 'Search-Instagram',
        meta: { authRequired: true },
        component: () => import('../views/pages/search/searchInstagram')
    },
    {
        path: '/search/naver',
        name: 'Search-Naver',
        meta: { authRequired: true },
        component: () => import('../views/pages/search/searchNaver')
    },

    {
        path: '/setting/category',
        name: 'Setting-category',
        meta: { authRequired: true },
        component: () => import('../views/pages/setting/category')
    },

]
