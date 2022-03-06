import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            alias: '/login',
            name: 'login',
            component: () => import('./components/Login')
        },
        {
            path: '/temp',
            alias: '/customers',
            name: 'customers',
            component: () => import('./components/CustomerList')
        },
        {
            path: '/customers/:id',
            name: 'edit-customer',
            component: () => import('./components/EditCustomer')
        },
        {
            path: '/add',
            name: 'add-customer',
            component: () => import('./components/AddCustomer')
        }
    ]
})

// router.beforeEach((to, from, next) => {
//     // redirect to login page if not logged in and trying to access a restricted page
//     const publicPages = ['/login'];
//     const authRequired = !publicPages.includes(to.path);
//     const loggedIn = localStorage.getItem('user');
  
//     if (authRequired && !loggedIn) {
//       return next({ 
//         path: '/login', 
//         query: { returnUrl: to.path } 
//       });
//     }
  
//     next();
//   })