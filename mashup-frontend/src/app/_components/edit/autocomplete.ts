// tslint:disable-next-line:class-name
export class autocomplete {

    getCppCompletionProvider(monaco) {
        return {
            provideCompletionItems: function (model, position) {
                // tslint:disable-next-line:max-line-length
                const completionItems = [{ label: 'arrays', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'SQL', documentation: 'sql selector.'
            }
            ];
                return completionItems;
          }
        };
    }
    getCCompletionProvider(monaco) {
        return {
            provideCompletionItems: function (model, position) {
                // tslint:disable-next-line:max-line-length
                const completionItems = [{ label: 'basic', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'SQL', documentation: 'sql selector.' },
            ];
                return completionItems;
            }
        };
    }
    getPythonCompletionProvider(monaco) {
        return {
            provideCompletionItems: function (model, position) {
                // tslint:disable-next-line:max-line-length
                const completionItems = [{ label: 'print', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'SQL', documentation: 'sql selector.' }

            ];
                return completionItems;

            }
        };
    }
    getJavaCompletionProvider(monaco) {
        return {
            provideCompletionItems: function (model, position) {
                // tslint:disable-next-line:max-line-length
                const completionItems = [{ label: 'Integer', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'SQL', documentation: 'sql selector.'} ];
                return completionItems;

            }
        };
    }
}
