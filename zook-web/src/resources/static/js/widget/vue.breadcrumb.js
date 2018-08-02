/*
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
Vue.component('vue-breadcrumb', {
    template: '<ul class="page-breadcrumb breadcrumb">' +
                    '<li>' +
                        '<a href="#">首页</a>' +
                    '</li>' +
                    '<template v-for="item in items">' +
                        '<li><i class="fa fa-lg fa-angle-right"></i></li>' +
                        '<li class="active" v-html="item"></li>' +
                    '</template>' +
                '</ul>',
    props: ["firstName", "secondName", "thirdName"],
    computed: {
        items: function(){
            var list = [];
            for(var t in this._props) {
                if (this[t]) {
                    list.unshift(this[t]);
                }
            }
            return list;
        }
    }
});
