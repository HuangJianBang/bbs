$("#am-md-btn").markdown({
height:300,
buttons: [
  [{
    name: 'groupFont',
    data: [{
      name: 'cmdBold',
      hotkey: 'Ctrl+B',
      title: '粗体',
      icon: 'am-icon-bold',
      btnClass: 'am-btn am-btn-danger',

      callback: function(e) {

        var chunk, cursor, selected = e.getSelection(),
          content = e.getContent();

        if (selected.length === 0) {
          // 设置提示信息
          chunk = '粗体文字';
        } else {
          chunk = selected.text;
        }

        // 触发粗体与设置光标位置
        if (content.substr(selected.start - 2, 2) === '**' &&
          content.substr(selected.end, 2) === '**') {
          e.setSelection(selected.start - 2, selected.end + 2);
          e.replaceSelection(chunk);
          cursor = selected.start - 2;
        } else {
          e.replaceSelection('**' + chunk + '**');
          cursor = selected.start + 2;
        }

        // 设置鼠标位置
        e.setSelection(cursor, cursor + chunk.length);
      }
    },
    {
      name: 'cmdItalic',
      title: '斜体',
      hotkey: 'Ctrl+I',
      icon: 'am-icon-italic ',
      btnClass: 'am-btn',
      callback: function(e) {

        var chunk, cursor, selected = e.getSelection(),
          content = e.getContent();

        if (selected.length === 0) {
          chunk = '斜体文字';
        } else {
          chunk = selected.text;
        }

        if (content.substr(selected.start - 1, 1) === '_' &&
          content.substr(selected.end, 1) === '_') {
          e.setSelection(selected.start - 1, selected.end + 1);
          e.replaceSelection(chunk);
          cursor = selected.start - 1;
        } else {
          e.replaceSelection('_' + chunk + '_');
          cursor = selected.start + 1;
        }

        e.setSelection(cursor, cursor + chunk.length);
      }
    },
    {
      name: 'cmdHeading',
      title: '标题',
      hotkey: 'Ctrl+H',
      icon: 'am-icon-header ',
      btnClass: 'am-btn',
      callback: function(e) {
        var chunk, cursor, selected = e.getSelection(),
          content = e.getContent(),
          pointer, prevChar;

        if (selected.length === 0) {
          chunk = '标题文字';
        } else {
          chunk = selected.text + '\n';
        }

        if ((pointer = 4, content.substr(selected.start - pointer, pointer) === '### ') ||
          (pointer = 3, content.substr(selected.start - pointer, pointer) === '###')) {
          e.setSelection(selected.start - pointer, selected.end);
          e.replaceSelection(chunk);
          cursor = selected.start - pointer;
        } else if (selected.start > 0 && (prevChar = content.substr(selected.start - 1, 1), !!prevChar && prevChar != '\n')) {
          e.replaceSelection('\n\n### ' + chunk);
          cursor = selected.start + 6;
        } else {
          // Empty string before element
          e.replaceSelection('### ' + chunk);
          cursor = selected.start + 4;
        }

        e.setSelection(cursor, cursor + chunk.length);
      }
    }]
  },
  {
    name: 'groupLink',
    data: [{
      name: 'cmdUrl',
      title: '链接',
      hotkey: 'Ctrl+L',
      icon: 'am-icon-link ',
      callback: function(e) {
        var chunk, cursor, selected = e.getSelection(),
          content = e.getContent(),
          link;

        if (selected.length === 0) {
          chunk = '链接描述';
        } else {
          chunk = selected.text;
        }

        link = prompt('输入链接地址', 'http://');

        var urlRegex = new RegExp('^((http|https)://|(mailto:)|(//))[a-z0-9]', 'i');
        if (link !== null && link !== '' && link !== 'http://' && urlRegex.test(link)) {
          var sanitizedLink = $('<div>' + link + '</div>').text();

          e.replaceSelection('[' + chunk + '](' + sanitizedLink + ')');
          cursor = selected.start + 1;

          e.setSelection(cursor, cursor + chunk.length);
        }
      }
    },
    {
      name: 'cmdImage',
      title: '图片',
      hotkey: 'Ctrl+G',
      icon: 'am-icon-picture-o ',
      callback: function(e) {
        var chunk, cursor, selected = e.getSelection(),
          content = e.getContent(),
          link;

        if (selected.length === 0) {
          chunk = '描述下图片吧';
        } else {
          chunk = selected.text;
        }

        link = prompt('输入图片地址', 'http://');

        var urlRegex = new RegExp('^((http|https)://|(//))[a-z0-9]', 'i');
        if (link !== null && link !== '' && link !== 'http://' && urlRegex.test(link)) {
          var sanitizedLink = $('<div>' + link + '</div>').text();

          e.replaceSelection('![' + chunk + '](' + sanitizedLink + ' "' + '输入图片标题' + '")');
          cursor = selected.start + 2;

          e.setNextTab('在这里输入图片标题');

          e.setSelection(cursor, cursor + chunk.length);
        }
      }
    }]
  }, {
    name: 'groupMisc',
    data: [{
      name: 'cmdList',
      hotkey: 'Ctrl+U',
      title: '无序列表',
      icon: 'am-icon-list-ul ',
      callback: function(e) {
        var chunk, cursor, selected = e.getSelection(),
          content = e.getContent();

        if (selected.length === 0) {
          chunk = '无序列表';

          e.replaceSelection('- ' + chunk);
          cursor = selected.start + 2;
        } else {
          if (selected.text.indexOf('\n') < 0) {
            chunk = selected.text;

            e.replaceSelection('- ' + chunk);

            cursor = selected.start + 2;
          } else {
            var list = [];

            list = selected.text.split('\n');
            chunk = list[0];

            $.each(list, function(k, v) {
              list[k] = '- ' + v;
            });

            e.replaceSelection('\n\n' + list.join('\n'));

            cursor = selected.start + 4;
          }
        }

        e.setSelection(cursor, cursor + chunk.length);
      }
    }, {
      name: 'cmdListO',
      hotkey: 'Ctrl+O',
      title: '有序列表',
      icon: 'am-icon-list-ol ',
      callback: function(e) {

        var chunk, cursor, selected = e.getSelection(),
          content = e.getContent();

        if (selected.length === 0) {
          chunk = '有序列表';
          e.replaceSelection('1. ' + chunk);
          cursor = selected.start + 3;
        } else {
          if (selected.text.indexOf('\n') < 0) {
            chunk = selected.text;

            e.replaceSelection('1. ' + chunk);

            cursor = selected.start + 3;
          } else {
            var i = 1;
            var list = [];

            list = selected.text.split('\n');
            chunk = list[0];

            $.each(list, function(k, v) {
              list[k] = i + '. ' + v;
              i++;
            });

            e.replaceSelection('\n\n' + list.join('\n'));

            cursor = selected.start + 5;
          }
        }

        e.setSelection(cursor, cursor + chunk.length);
      }
    }, {
      name: 'cmdCode',
      hotkey: 'Ctrl+K',
      title: '代码',
      icon: 'am-icon-code ',
      callback: function(e) {
        var chunk, cursor, selected = e.getSelection(),
          content = e.getContent();

        if (selected.length === 0) {
          chunk = '在这里输入代码';
        } else {
          chunk = selected.text;
        }

        if (content.substr(selected.start - 4, 4) === '```\n' &&
          content.substr(selected.end, 4) === '\n```') {
          e.setSelection(selected.start - 4, selected.end + 4);
          e.replaceSelection(chunk);
          cursor = selected.start - 4;
        } else if (content.substr(selected.start - 1, 1) === '`' &&
          content.substr(selected.end, 1) === '`') {
          e.setSelection(selected.start - 1, selected.end + 1);
          e.replaceSelection(chunk);
          cursor = selected.start - 1;
        } else if (content.indexOf('\n') > -1) {
          e.replaceSelection('```\n' + chunk + '\n```');
          cursor = selected.start + 4;
        } else {
          e.replaceSelection('`' + chunk + '`');
          cursor = selected.start + 1;
        }

        e.setSelection(cursor, cursor + chunk.length);
      }
    }, {
      name: 'cmdQuote',
      hotkey: 'Ctrl+Q',
      title: '引用',
      icon:  'am-icon-quote-left ',
      callback: function(e) {
        var chunk, cursor, selected = e.getSelection(),
          content = e.getContent();

        if (selected.length === 0) {
          chunk = '引用文字';

          e.replaceSelection('> ' + chunk);

          cursor = selected.start + 2;
        } else {
          if (selected.text.indexOf('\n') < 0) {
            chunk = selected.text;

            e.replaceSelection('> ' + chunk);

            cursor = selected.start + 2;
          } else {
            var list = [];

            list = selected.text.split('\n');
            chunk = list[0];

            $.each(list, function(k, v) {
              list[k] = '> ' + v;
            });

            e.replaceSelection('\n\n' + list.join('\n'));

            cursor = selected.start + 4;
          }
        }

        e.setSelection(cursor, cursor + chunk.length);
      }
    }]
  }, {
    name: 'groupUtil',
    data: [{
      name: 'cmdPreview',
      toggle: true,
      hotkey: 'Ctrl+P',
      title: '预览',
      btnText: '预览',
      btnClass: 'am-btn am-btn-primary',
      icon:  'am-icon-tv ',
      callback: function(e) {
        var isPreview = e.$isPreview,
          content;

        if (isPreview === false) {
          e.showPreview();
        } else {
          e.hidePreview();
        }
      }
    }]
  }]
],
additionalButtons: [
  [{
        name: "groupCustom",
        data: [{
          name: "cmdBeer",
          title: "Beer",
          btnText: "我是额外加的",
          icon: "am-icon-angellist am-icon-spin ",
          callback: function(e){
            alert('请在console控制台中查看事件对象')
            console.log(e)
          }
        }]
  }]
]
})
