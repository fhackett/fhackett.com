import './slidesFormatting.css'

(() => {
  const roots = document.getElementsByClassName("slideshow-root")
  Array.from(roots).forEach(root => {
    const slides = Array.from(root.getElementsByClassName("slideshow-slide"))
    let slideIdx = 0;
    (() => {
      const url = new URL(window.location.href)
      const oldSlideNum = url.searchParams.get("slide")
      if(oldSlideNum !== null) {
        const idx = parseInt(oldSlideNum) - 1
        if(idx >= 0) {
          slideIdx = idx
        } else if(idx >= slides.length && slides.length > 0) {
          slideIdx = slides.length - 1
        }
      }
    })()

    const showCurrentSlide = () => {
      slides.forEach((slide, idx) => {
        if(idx === slideIdx) {
          slide.classList.remove("hidden")
        } else {
          slide.classList.add("hidden")
        }
      })

      const url = new URL(window.location.href)
      url.searchParams.set("slide", slideIdx + 1)
      window.history.pushState({}, "", url)
    }

    const setFullScale = () => {
      root.classList.remove("text-[2dvh]", "h-[80dvh]")
      root.classList.add("text-[2.5dvh]", "h-[100dvh]")
    }
    const setPartScale = () => {
      root.classList.remove("text-[2.5dvh]", "h-[100dvh]")
      root.classList.add("text-[2dvh]", "h-[80dvh]")
    }

    showCurrentSlide()

    document.addEventListener('fullscreenchange', event => {
      if(document.fullscreenElement) {
        setFullScale()
      } else {
        setPartScale()
      }
    })

    window.addEventListener('beforeprint', event => {
      setFullScale()
    })

    window.addEventListener('afterprint', event => {
      setPartScale()
    })

    root.addEventListener('keydown', event => {
      switch(event.key) {
        case "f":
          if(!Document.fullscreenElement) {
            root.requestFullscreen().catch(err => {
              window.alert(`failed to get fullscreen: ${err}`)
            })
          }
        break;
        case "ArrowRight":
          if(slideIdx < slides.length - 1) {
            slideIdx += 1
            showCurrentSlide()
          }
        break;
        case "ArrowLeft":
          if(slideIdx > 0){
            slideIdx -= 1
            showCurrentSlide()
          }
        break;
        case "Home":
          slideIdx = 0
          showCurrentSlide()
        break;
        case "End":
          slideIdx = slides.length > 0 ? slides.length - 1 : 0
          showCurrentSlide()
        break;
      }
    })
  });
})()
