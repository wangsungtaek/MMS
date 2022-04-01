export const menuItems = [
    {
        id: 1,
        label: '대시보드',
        icon: 'ri-dashboard-line',
        link: '/'
    },
    {
        id: 2,
        label: '프로젝트',
        icon: 'ri-projector-fill',
        subItems: [
            {
                id: 3,
                label: '프로젝트 목록',
                link: '/project/list'
            },
            {
                id: 4,
                label: '프로젝트 캘린더',
                link: '/project/calendar'
            },
            {
                id: 5,
                label: '프로젝트 생성',
                link: '/project/create'
            },
        ]
    },
    {
        id: 6,
        label: '리뷰어',
        icon: 'ri-user-fill',
        subItems: [
            {
                id: 7,
                label: '리뷰어 통합 검색',
                link: '/reviewer/all'
            },
            {
                id: 8,
                label: '리뷰어 - 네이버',
                link: '/reviewer/naver'
            },
            {
                id: 9,
                label: '리뷰어 - 인스타그램',
                link: '/reviewer/instagram'
            },
            {
                id: 10,
                label: '리뷰어 - 페이스북',
                link: '/reviewer/facebook'
            },
            {
                id: 11,
                label: '리뷰어 - 유튜브',
                link: '/reviewer/youtube'
            }
        ]
    },
    {
        id: 12,
        label: '리뷰어 발굴',
        icon: 'ri-search-eye-line',
        subItems: [
            {
                id: 13,
                label: '인스타그램',
                link: '/search/instagram'
            },
            {
                id: 14,
                label: '네이버',
                link: '/search/naver'
            },
        ]
    },
]