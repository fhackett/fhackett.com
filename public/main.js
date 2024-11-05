import './fonts.css'
import '@unocss/reset/normalize.css'
import 'uno.css'

(() => {
  const navbarOpen = document.getElementById("navbar-open")
  const navbarClose = document.getElementById("navbar-close")

  const navbarItems = document.getElementsByClassName("navbar-item")

  const toggleElements = () => {
    navbarOpen.classList.toggle("hidden");
    navbarClose.classList.toggle("hidden");
    Array.from(navbarItems).forEach(element => {
      element.classList.toggle("hidden");
    });
  }

  navbarOpen.onclick = toggleElements
  navbarClose.onclick = toggleElements
})()

Array.from(document.getElementsByClassName("show-more-container")).forEach(musicRelease => {
  const [content] = Array.from(musicRelease.getElementsByClassName("show-more-content"))
  const [showLess] = Array.from(musicRelease.getElementsByClassName("show-more-button-less"))
  const [showMore] = Array.from(musicRelease.getElementsByClassName("show-more-button-more"))

  let heightCls = "???"

  content.classList.forEach(cls => {
    const pfx = "show-more-cls-"
    if(cls.startsWith(pfx)) {
      heightCls = cls.slice(pfx.length)
    }
  })

  const isUnset = () =>
    showLess.classList.contains("hidden") && showMore.classList.contains("hidden")
  const isHiding = () =>
    showLess.classList.contains("hidden") && !showMore.classList.contains("hidden")

  const toggleShow = () => {
    showLess.classList.toggle("hidden")
    showMore.classList.toggle("hidden")
    content.classList.toggle(heightCls)
    content.classList.toggle("overflow-y-hidden")
  }

  showMore.onclick = toggleShow
  showLess.onclick = () => {
    toggleShow()
    updateOnResize()
  }

  const updateOnResize = () => {
    if(content.scrollHeight > 200) {
      if(isUnset()) {
        showMore.classList.remove("hidden")
      }
    } else {
      if(isHiding()) {
        showMore.classList.add("hidden")
      }
    }
  }

  updateOnResize()
  window.addEventListener("resize", updateOnResize)
})
