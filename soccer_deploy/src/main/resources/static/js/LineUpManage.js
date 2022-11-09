import { LineUpMember } from "./LineUpMember.js"

function LineUpManager() {
  this.array = [];
}

LineUpManager.prototype.add = function (member) {
  this.array.push(member);
}

LineUpManager.prototype.delplayer = function (backNum,quarter) {
  return this.array.filter(function (lineUpMember) {
    console.log(lineUpMember.backNum );
    console.log(backNum);
    return (lineUpMember.backNum !== backNum || lineUpMember.quarter !==quarter);
  })
}
export { LineUpManager };