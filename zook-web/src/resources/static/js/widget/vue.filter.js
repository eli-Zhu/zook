/**
 * Created by hzy24985 on 2016/4/25.
 */

/**
 * 将后台传来的数字型日期转成日期字符串, 格式按照momentjs类库做转换.
 * eg. data | toDate 'YYYY-MM-DD'
 *
 * @param format {String} 日期格式, 参照momentjs.
 */
Vue.filter('toDate', {
    read: function(value, format) {
        return moment(value).format(format);
    },
    write: function (value, format) {
        return value;
    }
})