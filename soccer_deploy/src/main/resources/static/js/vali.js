const regLimit = /[^0-9]/g;
const regZero = /^0[0-9]+$/g;

let vali= {};

vali.Limit = function(point){
    return regLimit.test(point);
}
vali.Zero = function(point){
    return regZero.test(point);
}
export {vali};