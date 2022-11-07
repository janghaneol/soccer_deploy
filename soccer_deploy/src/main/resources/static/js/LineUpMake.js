import { LineUpMember } from "./LineUpMember.js";
import { LineUpManager } from "./LineUpManager.js";
let container, box;
let dragon = false;
let originLeft = null;
let originTop = null;
let originX = null;
let originY = null;
let boxwidth = null;
let boxheight = null;
let containerwidth = null;
let containerheight = null;
let playerList = null;
let addPlayerPosition = null;
let chanX = null;
let chanY = null;
let manager = new LineUpManager();
//상황판 드래그 영역
document.querySelector("#lineUp").addEventListener("mouseover", function (event) {

  if (event.target && event.target.id == "dragin") {

    container = event.target;
    const { width: containerWidth, height: containerHeight } = container.getBoundingClientRect();
    containerwidth = containerWidth;
    containerheight = containerHeight;

    container.addEventListener("mousedown", function (event) {
      if (event.target && event.target.id == "player") {
        dragon = true;
        box = event.target
        const { width: boxWidth, height: boxHeight } = box.getBoundingClientRect();
        originX = event.clientX;
        originY = event.clientY;
        originLeft = box.offsetLeft;
        originTop = box.offsetTop;
        boxwidth = boxWidth;
        boxheight = boxHeight;
      }
    });
  }
});

document.addEventListener("mouseup", function (event) {
  dragon = false;
  chanX = event.clientX;
  chanY = event.clientY;
});
document.addEventListener("mousemove", function (event) {
  if (dragon) {
    const diffX = event.clientX - originX;
    const diffY = event.clientY - originY;
    const endOfXPoint = containerwidth - boxwidth;
    const endOfYPoint = containerheight - boxheight;
    box.style.left = `${Math.min(Math.max(0, originLeft + diffX), endOfXPoint)}px`;
    box.style.top = `${Math.min(Math.max(0, originTop + diffY), endOfYPoint)}px`;
  }
});
//상황판 드래그 영역==========================================================

//상황판 클릭 영역 ==========================================================
document.querySelector("#lineUp").addEventListener("click", function (event) {
  if (event.target && event.target.id == "player") {
    addPlayerPosition = event.target;
    console.log(manager.array);

    if (chanX == originX && chanY == originY) {
      if(addPlayerPosition.classList.contains("empty"))
      document.querySelector(".search").style.display = "inline-block";
      //클릭시 창 띄우기
    }
  } else if (event.target && event.target.classList.contains("cancle")) {
    let form = event.target.parentElement; // player

    while (form.hasChildNodes()) {
      form.removeChild(form.firstChild);
    }
    removePlayer(form);
    form.classList.replace("full", "empty");
    delete form.dataset.num;
    delete form.dataset.name;
    // form.classList.
  }
});
//상황판 클릭 영역 ==========================================================


//리스트 클릭 =============================================================
document.querySelector(".list").addEventListener("click", function (event) {
  if (event.target && event.target.id == "play") {
    playerList = event.target;
    console.log(playerList);
    addPlayer(playerList);
    let search = document.querySelector(".search");
    search.style.display = "none";

  }
  if (event.target && event.target.id == "pl") {
    playerList = event.target.parentElement;
    console.log(playerList);
    addPlayer(playerList);
    let search = document.querySelector(".search");
    search.style.display = "none";
  }
});
//리스트 클릭 =============================================================


//클릭시 선수 추가 =========================================================
function addPlayer(target) {
  let bool = true;

  let test = document.querySelectorAll(`.${addPlayerPosition.classList[1]}`);

  test.forEach(element => {
    if (element.dataset.num == target.dataset.num) {
      bool = false;
    }
  });
  if (bool) {
    if (addPlayerPosition.classList.contains("empty")) {
      let div = document.createElement("div");
      let spanBackNum = document.createElement("span");
      let spanName = document.createElement("span");
      let backNum = document.createTextNode(target.dataset.num);
      let name = document.createTextNode(target.dataset.name);
      spanBackNum.appendChild(backNum);
      spanName.appendChild(name);
      div.classList.add('nameNum');
      div.appendChild(spanBackNum);
      div.appendChild(spanName);

      let button = document.createElement("button");
      let val = document.createTextNode("X");
      button.appendChild(val);
      addPlayerPosition.dataset.num = target.dataset.num;
      addPlayerPosition.dataset.name = target.dataset.name;
      addPlayerPosition.dataset.playId = target.dataset.playId;
      button.classList.add('cancle');

      addPlayerPosition.style.backgroundImage = "url('../images/img_2.jpg')";

      addPlayerPosition.appendChild(div);
      addPlayerPosition.appendChild(button);
      addPlayerPosition.classList.replace("empty", "full");
      let quarter = addPlayerPosition.classList[1];
      switch (quarter) {
        case "first":
          playerList.lastElementChild.children[0].classList.add("part");
          break;
        case "second":
          playerList.lastElementChild.children[1].classList.add("part");
          break;
        case "third":
          playerList.lastElementChild.children[2].classList.add("part");
          break;
        case "fourth":
          playerList.lastElementChild.children[3].classList.add("part");
          break;
      }
      manager.add(new LineUpMember(target.dataset.num, target.dataset.name, 0, 0, 0, addPlayerPosition.parentElement.dataset.quarter, addPlayerPosition.dataset.playerId));
    }
  }
};
//클릭시 선수 추가 =========================================================

//삭제 버튼 클릭
function removePlayer(target) {
  let del = null;
  // form.classList[1]; //만약 첫번째가 나오고 first나오고 일단
  // form.dataset.num; // 만약 5를 받아오고
  //폼을 받아오고
  target.style.removeProperty("background-image");
  let list = document.querySelectorAll(".player_list")
  list.forEach(element => {
    if (element.dataset.num == target.dataset.num) {
      del = element;
    }
  });

  switch (target.classList[1]) {
    case "first":
      del.lastElementChild.children[0].classList.remove("part");
      break;
    case "second":
      del.lastElementChild.children[1].classList.remove("part");
      break;
    case "third":
      del.lastElementChild.children[2].classList.remove("part");
      break;
    case "fourth":
      del.lastElementChild.children[3].classList.remove("part");
      break;
  }
  manager.array = manager.delplayer(target.dataset.num, target.parentElement.dataset.quarter);
}

document.querySelector(".chan_set").addEventListener("click", function (event) {
  if (event.target && event.target.classList.contains("make_first")) {
    open(0);
    console.log("test");
  } else if (event.target && event.target.classList.contains("make_second")) {
    open(1);
  }
  else if (event.target && event.target.classList.contains("make_third")) {
    open(2);
  }
  else if (event.target && event.target.classList.contains("make_fourth")) {
    open(3);
  }
})

function open(sequence) {
  let i = document.querySelectorAll(".dragin").length;
  for (let j = 0; j < i; j++) {
    if (j == sequence) {
      if (document.querySelectorAll(".dragin")[j].classList.contains("close")) {
        document.querySelectorAll(".dragin")[j].classList.replace("close", "open");
      }
    } else {
      if (document.querySelectorAll(".dragin")[j].classList.contains("open")) {
        document.querySelectorAll(".dragin")[j].classList.replace("open", "close");
      }
    }

  }
}

document.querySelector(".close_pop").addEventListener("click", function (event) {
  let search = document.querySelector(".search");
  search.style.display = "none";
})

