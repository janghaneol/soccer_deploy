function openLayerPopup(id, width, height, el) {
			const $popup = document.getElementById(id);
			const $mask = document.getElementById('layer-mask');
			const $close = $popup.querySelector('.close');
			const $last = $popup.querySelector('.last');
			const $return = el;

			// 팝업창 표시
			$popup.setAttribute('style', 'width: ' + width + 'px; height: '
					+ height + 'px;');
			$popup.setAttribute('tabindex', 0);
			$last.setAttribute('tabindex', 0);
			$popup.insertAdjacentHTML('beforebegin', '<a href="#"></a>');
			$popup.insertAdjacentHTML('afterend', '<a href="#"></a>');
			$mask.classList.add('on');
			$popup.classList.add('on');
			$popup.focus();

			// 팝업창 닫기
			$close.addEventListener('click', close, false);

			// focus
			$popup.previousElementSibling.addEventListener('focusin',
					function() {
						$last.focus();
					}, false);
			$popup.nextElementSibling.addEventListener('focusin', function() {
				$popup.focus();
			}, false);

			function close() {
				$return.focus();
				$mask.classList.remove('on');
				$popup.classList.remove('on');
				$close.removeEventListener('click', close, false);
				$popup.previousElementSibling.remove();
				$popup.nextElementSibling.remove();
			}
		}