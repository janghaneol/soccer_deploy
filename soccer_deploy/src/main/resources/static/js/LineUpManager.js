import { LineUpMember } from "./LineUpMember.js"

function LineUpManager() {
  this.array = [];
}

LineUpManager.prototype.add = function (member) {
  this.array.push(member);
}

LineUpManager.prototype.delplayer = function (backNum,quarter) {
  return this.array.filter(function (lineUpMember) {
    return (lineUpMember.backNum !== backNum || lineUpMember.quarter !==quarter);
  })
}

LineUpManager.prototype.checkPlayer = function(backNum,quarter){
  return this.array.filter(function (lineUpMember){
    return (lineUpMember.backNum == backNum && lineUpMember.quarter == quarter) ;
  })
};
export { LineUpManager };