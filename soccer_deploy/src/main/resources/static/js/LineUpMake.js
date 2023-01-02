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
    if (chanX == originX && chanY == originY) {
      if (addPlayerPosition.classList.contains("empty"))
        document.querySelector(".search").style.display = "inline-block";
      let option = {
        method: 'POST',
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify("")
      }
      fetch(`/lineup`, option)
        .then(response => response.json())
        .then(response => { printEntry(response) });



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

    addPlayer(playerList);
    let search = document.querySelector(".search");
    search.style.display = "none";

  }
  if (event.target && event.target.id == "pl") {
    playerList = event.target.parentElement;

    addPlayer(playerList);
    let search = document.querySelector(".search");
    search.style.display = "none";
  }
});
//리스트 클릭 =============================================================


//클릭시 선수 추가 =========================================================
function addPlayer(target) {
  let bool = true;
console.log(manager.array);
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
      addPlayerPosition.dataset.playId = target.dataset.playid;
      button.classList.add('cancle');
      //let imgName = target.dataset.imgname; 나중에 이미지 파일 위치 나오면 수정해야함 20221112
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
      manager.add(new LineUpMember(target.dataset.num, target.dataset.name, 0, 0, 0, addPlayerPosition.parentElement.dataset.quarter, addPlayerPosition.dataset.playId));
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

  let search = document.querySelector(".search");
  search.style.display = "none";
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
document.querySelector(".searchval").addEventListener("keyup", function (event) {
  if (event.keyCode === 13) {
    event.preventDefault();
    document.querySelector(".nameSearch").click();
  }
})
document.querySelector(".nameSearch").addEventListener("click", function (event) {
  let name = document.querySelector(".searchval").value;
  // console.log(nameValue);
  let option = {
    method: 'POST',
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(name)
  }
  fetch(`/lineup`, option)
    .then(response => response.json())
    .then(response => { printEntry(response) });
})

function printEntry(response) {
  let list = "";
  let firstVal = document.querySelector(".first_set").dataset.quarter;
  let arr = ['one', 'two', 'three', 'four'];
  let span = "";


  for (let i = 0; i < response.length; i++) {
    for (let j = 0; j < document.querySelector("#size").value; j++) {
      let qu = document.querySelectorAll(".dragin")[j].dataset.quarter;
      if (manager.checkPlayer(response[i].user.backNum, qu).length != 0) {
        span += `<span class="quarter_${arr[j]} part">${j + 1}set</span>`;
      }
      else {
        span += `<span class="quarter_${arr[j]}">${j + 1}set</span>`;
      }
    }
    list += `<tr class="board player_list" id="play"
    data-num="${response[i].user.backNum}"
    data-name="${response[i].user.name}" data-playid="${response[i].id}" data-imgname="${response[i].user.imgFileName}">
    <td id="pl" class="back_num"><strong>${response[i].user.backNum}</strong></td>
    <td id="pl" class="line_up_name">${response[i].user.name}</td>
    <td id="pl" class="posit">${response[i].user.position}</td>
    <td id="pl" class="quarter">${span}</td>
  </tr>`
    span = "";
  }
  document.querySelector(".bodypart").innerHTML = list;
}
document.querySelector(".ml-auto").addEventListener("click", function (event) {
  if (event.target && event.target.classList.contains("nav-link")) {
    event.preventDefault();
    console.log(event.target);
    document.querySelector(".pop").style.display = "flex";
    let movepage = document.createElement("a");
    movepage.href = event.target.href;
    document.querySelector("div.btn_pop").addEventListener("click", function (event) {
      if (event.target && event.target.classList.contains("Ysave")) {
        let marray =  manager.sorting(manager.array);
        console.log(marray);
        let option = {
          method: 'POST',
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(marray)
        }

        fetch(`/lineup/entry`, option)

      } else {
        console.log("no");
      }

      document.body.appendChild(movepage);
      movepage.click();
      document.body.removeChild(movepage);
    })
  }
})

document.querySelector(".site-mobile-menu").addEventListener("click", function (event) {
  if (event.target && event.target.classList.contains("nav-link")) {
    event.preventDefault();
    console.log(event.target);
    document.querySelector(".pop").style.display = "flex";
    let movepage = document.createElement("a");
    movepage.href = event.target.href;
    document.querySelector("div.btn_pop").addEventListener("click", function (event) {
      if (event.target && event.target.classList.contains("Ysave")) {
        let marray =  manager.sorting(manager.array);
        
        let option = {
          method: 'POST',
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(marray)
        }

        fetch(`/lineup/entry`, option);
      } else {
        console.log("no");
      }

      document.body.appendChild(movepage);
      movepage.click();
      document.body.removeChild(movepage);
    })
  }else if (event.target && event.target.classList.contains("drop")) {
    event.preventDefault();
    console.log(event.target);
    document.querySelector(".pop").style.display = "flex";
    let movepage = document.createElement("a");
    movepage.href = event.target.href;
    document.querySelector("div.btn_pop").addEventListener("click", function (event) {
      if (event.target && event.target.classList.contains("Ysave")) {
        let marray =  manager.sorting(manager.array);
        
        let option = {
          method: 'POST',
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(marray)
        }

        fetch(`/lineup/entry`, option);
      } else {
        console.log("no");
      }

      document.body.appendChild(movepage);
      movepage.click();
      document.body.removeChild(movepage);
    })

  }
})

document.querySelector(".dropdown-menu").addEventListener("click", function (event) {
  if (event.target && event.target.classList.contains("drop")) {
    event.preventDefault();
    console.log(event.target);
    document.querySelector(".pop").style.display = "flex";
    let movepage = document.createElement("a");
    movepage.href = event.target.href;
    document.querySelector("div.btn_pop").addEventListener("click", function (event) {
      if (event.target && event.target.classList.contains("Ysave")) {
        let marray =  manager.sorting(manager.array);
        
        let option = {
          method: 'POST',
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(marray)
        }

        fetch(`/lineup/entry`, option);
      } else {
        console.log("no");
      }

      document.body.appendChild(movepage);
      movepage.click();
      document.body.removeChild(movepage);
    })

  }
})

// document.querySelector(".site-mobile-menu").addEventListener("click", function (event) {
//   console.log(manager);
// })